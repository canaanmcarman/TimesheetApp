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
    public String processTimesheet(@PathVariable("id") long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        timesheet.setStage("pending approval");
        model.addAttribute("timesheet", timesheet);
        //email section
        //for admin
        String header = " header ....";
        String contentForAdmin = "Employee has submitted a timesheet for review. Please check the queue.";
        String emailAdmin = "ccamaru89@gmail.com";
        //for employee
        String contentForEmployee = "Hi Employee, your timesheet was submitted and is pending approval";
        User employee = timesheet.getEmployee();
        String emailEmployee = employee.getEmail();
        emailService.sendSimpleEmail(contentForAdmin, header, emailAdmin);
        emailService.sendSimpleEmail(contentForEmployee, header, emailEmployee);
        timesheetRepository.save(timesheet);
//        emailService.SendTemplatedEmail("Employee submitted timesheet for approval");
        return "testtable";
    }


    @PostMapping("/savetimesheet")
    public String saveTimesheet(@ModelAttribute Timesheet timesheet, Model model, Principal principal) {
        timesheet.setStage("edit");
//        Action action = new Action();
//        LocalDate date = LocalDate.now();
//        action.setDate(date);
//        actionRepository.save(action);
        timesheet.calcWeekPay(20.0);
        String username = principal.getName();
        timesheet.setEmployee(userRepository.findByUsername(username));
        timesheetRepository.save(timesheet);
        model.addAttribute("timesheet", timesheet);
        return "testtable";
    }
    @RequestMapping("/approve/{id}")
    public String approveTimesheet(@PathVariable("id") long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        timesheet.setStage("approved");
        model.addAttribute("timesheet", timesheet);
        timesheetRepository.save(timesheet);

        // send user a paystub

        return "index";
    }

    @RequestMapping("/reject/{id}")
    public String rejectTimesheet() {

        return "index";
    }

    @RequestMapping("/timesheet/{id}")
    public String viewTimesheet(@PathVariable("id") long id, Model model) {
        model.addAttribute("timesheet", timesheetRepository.findById(id).get());
        return "testtable";
    }

    @RequestMapping("/edittimesheet/{id}")
    public String editTimesheet(@PathVariable("id") long id, Model model) {
        Timesheet timesheet = timesheetRepository.findById(id).get();
        model.addAttribute("timesheet", timesheet);
        if (timesheet.getStage().equals("approved")) {
            String message = "You have already submitted this timesheet for approval. If rejected by employer you can edit again";
            model.addAttribute("message", message);
            return "testtable";
        }
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

    @GetMapping("/sendApprovedEmail")
    public String sendApprovedEmail(){
        emailService.SendTemplatedEmail("your timesheet is approved");
        return "success";
    }
    @GetMapping("/sendRejectEmail")
    public String sendRejectEmail(){
//        emailService.sendSimpleEmail("your timesheet is rejected", "timesheet");
        return "success";
    }




}
