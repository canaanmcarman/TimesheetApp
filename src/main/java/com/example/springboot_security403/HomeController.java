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

    @PostMapping("/timesheetapproval")
    public String processTimesheet(@Valid Timesheet timesheet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "timesheetform";
        }
        timesheet.setStage("pending approval");
        timesheet.calcWeekPay(20.0);
        timesheetRepository.save(timesheet);
        model.addAttribute("timesheet", timesheet);
        return "testtable";
    }


    @PostMapping("/savetimesheet")
    public String saveTimesheet(@ModelAttribute Timesheet timesheet, Model model) {
        timesheet.setStage("edit");
//        Action action = new Action();
//        LocalDate date = LocalDate.now();
//        action.setDate(date);
//        actionRepository.save(action);
        timesheet.calcWeekPay(20.0);
        timesheetRepository.save(timesheet);
        model.addAttribute("timesheet", timesheet);
        return "testtable";
    }

    @RequestMapping("/timesheet/{id}")
    public String viewTimesheet(@PathVariable("id") long id, Model model) {
        model.addAttribute("timesheet", timesheetRepository.findById(id).get());
        return "timesheet";
    }

    @RequestMapping("/edittimesheet/{id}")
    public String editTimesheet(@PathVariable("id") long id, Model model) {
        model.addAttribute("timesheet", timesheetRepository.findById(id).get());
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

    @GetMapping("/sendApprovedEmail")
    public String sendApprovedEmail(){
        emailService.SendTemplatedEmail("your timesheet is approved");
        return "success";
    }
    @GetMapping("/sendRejectEmail")
    public String sendRejectEmail(){
        emailService.SendSimpleEmail("your timesheet is rejected", "timesheet");
        return "success";
    }
    @RequestMapping("/approvetimesheet")
    public String approveTimesheet() {
        return "index";
    }

    @RequestMapping("/rejecttimesheet")
    public String rejectTimesheet() {

        return "index";
    }

}
