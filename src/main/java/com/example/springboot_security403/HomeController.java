package com.example.springboot_security403;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;


@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EmailService emailService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addtimesheet")
    public String addTimesheet(Model model) {
        model.addAttribute("timesheet", new Timesheet());

        return "timesheetform";
    }

    @RequestMapping("/timesheetapproval/{id}")
    public String processTimesheet(@PathVariable("id") long id, Model model, Principal principal) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        //check if already sent for approval
        if (timesheet.getStage().equals("pending approval")) {
            String message = "You have already submitted this timesheet for approval. If rejected by employer you can edit again";
            model.addAttribute("message2", message);
            model.addAttribute("timesheet", timesheet);
            return "timesheet";
        }


        timesheet.setStage("pending approval");
        model.addAttribute("timesheet", timesheet);
        //email section
        //for admin
        String username = principal.getName();
        String header = " header ....";
        String contentForAdmin = username + " has submitted a timesheet for review. Please check the queue.";
        String emailAdmin = "ccamaru89@gmail.com";
        //for employee
        String contentForEmployee = "Hi," + username + " your timesheet was submitted and is pending approval";
        User employee = timesheet.getEmployee();
        String emailEmployee = employee.getEmail();
        emailService.sendSimpleEmail(contentForAdmin, header, emailAdmin);
        emailService.sendSimpleEmail(contentForEmployee, header, emailEmployee);
        timesheetRepository.save(timesheet);
//        emailService.SendTemplatedEmail("Employee submitted timesheet for approval");
        String message = "Submitted for approval! Check your email.";
        model.addAttribute("message3", message);

        //add action
        LocalDate date = LocalDate.now();
        Action action = new Action();
        action.setDate(date);
        action.setActionName("submitted timesheet for approval");
        action.setEmployee(employee);
        actionRepository.save(action);

        return "timesheet";

    }


    @PostMapping("/savetimesheet")
    public String saveTimesheet(@ModelAttribute Timesheet timesheet, Model model, Principal principal) {



        //set date
        LocalDate date = LocalDate.now();
        timesheet.setDate(date);

        //set action
        Action action = new Action();
        action.setDate(date);


        //calc pay
        timesheet.calcWeekPay(20);
        String username = principal.getName();

        //set stage
        if (timesheet.getStage() == null) {
            timesheet.setStage("create");
            action.setActionName("created timesheet");
        } else if (timesheet.getStage().isEmpty()){
            timesheet.setStage("create");
            action.setActionName("created timesheet");
        } else {
            timesheet.setStage("edit");
            action.setActionName("edited timesheet");
        }

        //save
        timesheet.setEmployee(userRepository.findByUsername(username));
        action.setEmployee(timesheet.getEmployee());
        timesheetRepository.save(timesheet);
        actionRepository.save(action);
        model.addAttribute("timesheet", timesheet);
        return "timesheet";
    }
    @RequestMapping("/approve/{id}")
    public String approveTimesheet(@PathVariable("id") long id, Model model, Principal principal) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        timesheet.setStage("approved");
        model.addAttribute("timesheet", timesheet);
        timesheetRepository.save(timesheet);

        //ruth changes

//        String username = principal.getName();
        String header = " header ....";
        User employee = timesheet.getEmployee();
        String emailEmployee = employee.getEmail();
        //for employee
        String contentForEmployee = "Hi " + timesheet.getEmployee().getFirstName() + ", your timesheet has been approved!" + "\n" + "\n" + "\n"
                + "Employee Name: " + timesheet.getEmployee().getFirstName() + " " + timesheet.getEmployee().getLastName() + "\n"
                + "Gross Earning: " + timesheet.getWeekTotal() + "\n"
                + "Hours Worked: " + timesheet.getRegular() + "\n";
//                + "Over Time worked: "+ timesheet.getOvertimeHours();

        emailService.sendSimpleEmail(contentForEmployee, header, emailEmployee);

        // send user a paystub

        return "paystub";

    }

    @RequestMapping("/reject/{id}")
    public String rejectTimesheet(@PathVariable("id") long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        timesheet.setStage("edit");
        model.addAttribute("timesheet", timesheet);
        timesheetRepository.save(timesheet);

        String header = " header ....";
        User employee = timesheet.getEmployee();
        String emailEmployee = employee.getEmail();
        //for employee
        String contentForEmployee = "Hi " + timesheet.getEmployee().getFirstName() + ", your timesheet was rejected. Please check that you inputted the correct hours" +
                "and send again";
        emailService.sendSimpleEmail(contentForEmployee, header, emailEmployee);

        return "redirect:/viewall";
    }

    @RequestMapping("/timesheet/{id}")
    public String viewTimesheet(@PathVariable("id") long id, Model model) {
        model.addAttribute("timesheet", timesheetRepository.findById(id).get());
        return "timesheet";
    }

    @RequestMapping("/edittimesheet/{id}")
    public String editTimesheet(@PathVariable("id") long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        model.addAttribute("timesheet", timesheet);
        if (timesheet.getStage().equals("approved")) {
            String message = "You have already submitted this timesheet for approval. If rejected by employer you can edit again";
            model.addAttribute("message", message);
            return "timesheet";
        }
        timesheet.setStage("edit");
        timesheetRepository.save(timesheet);
        return "timesheetform";
    }


    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        String username = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(username));
        return "secure";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/logout")
    public String logout(){
        return "redirect:/login?logout=true";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/processregister")
    public String processRegistrationPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.clearPassword();
            model.addAttribute("user", user);
            return "register";
        } else {
            model.addAttribute("user", user);
            model.addAttribute("message", "New user account created");
            user.setEnabled(true);
            userRepository.save(user);

            Role role = new Role(user.getUsername(), "ROLE_USER");
            roleRepository.save(role);
        }
        return "redirect:/login";
    }

    @RequestMapping("/viewall")
    public String viewAll(Model model) {
        model.addAttribute("timesheets", timesheetRepository.findAll());
        return "queue";
    }
    @RequestMapping("/viewpending")
    public String viewPending(Model model) {
        model.addAttribute("timesheets", timesheetRepository.findAllByStage("pending approval"));

        return "queuepending";
    }

}