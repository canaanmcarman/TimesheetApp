package com.example.springboot_security403;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User employee;

    private String payCode;

    private double weekTotal;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd")
//    private LocalDate date;

    private String stage;  //create, edit, pending approval, Approved


    //monday
    private double regularMonday;

    private double regularOvertimeMonday;

    private double leaveWithoutPayMonday;

    private double annualLeaveMonday;

    private double compTimeEarnedMonday;

    private double compTimeUsedMonday;

    private boolean holidayMonday;

    private double holidayWorkedMonday;



    private double holidayOvertimeMonday;

    //tuesday

    private double regularTuesday;

    private double leaveWithoutPayTuesday;

    private double annualLeaveTuesday;

    private double compTimeEarnedTuesday;

    private double compTimeUsedTuesday;

    private boolean holidayTuesday;

    private double holidayWorkedTuesday;

    private double regularOvertimeTuesday;

    private double holidayOvertimeTuesday;

    //weds

    private double regularWednesday;

    private double leaveWithoutPayWednesday;

    private double annualLeaveWednesday;

    private double compTimeEarnedWednesday;

    private double compTimeUsedWednesday;

    private boolean holidayWednesday;

    private double holidayWorkedWednesday;

    private double regularOvertimeWednesday;

    private double holidayOvertimeWednesday;

    //thurs
    private double regularThursday;

    private double leaveWithoutPayThursday;

    private double annualLeaveThursday;

    private double compTimeEarnedThursday;

    private double compTimeUsedThursday;

    private boolean holidayThursday;

    private double holidayWorkedThursday;

    private double regularOvertimeThursday;

    private double holidayOvertimeThursday;

    //friday
    private double regularFriday;

    private double leaveWithoutPayFriday;

    private double annualLeaveFriday;

    private double compTimeEarnedFriday;

    private double compTimeUsedFriday;

    private boolean holidayFriday;

    private double holidayWorkedFriday;

    private double regularOvertimeFriday;

    private double holidayOvertimeFriday;

    //total
    private double regular;
    private double annualLeave;
    private double holidayWorked;
    private double holidayOvertime;
    private double regularOvertime;
    private double compTimeEarned;

    private double totalHours = regular + annualLeave + holidayWorked + holidayOvertime + regularOvertime;



    public Timesheet() {

    }



    public double getCompTimeEarned() {
        return compTimeEarned;
    }

    public void setCompTimeEarned(double compTimeEarned) {
        this.compTimeEarned = compTimeEarned;
    }



    public double getRegular() {
        return regular;
    }

    public void setRegular(double regular) {
        this.regular = regular;
    }

    public double getAnnualLeave() {
        return annualLeave;
    }

    public void setAnnualLeave(double annualLeave) {
        this.annualLeave = annualLeave;
    }

    public double getHolidayWorked() {
        return holidayWorked;
    }

    public void setHolidayWorked(double holidayWorked) {
        this.holidayWorked = holidayWorked;
    }

    public double getHolidayOvertime() {
        return holidayOvertime;
    }

    public void setHolidayOvertime(double holidayOvertime) {
        this.holidayOvertime = holidayOvertime;
    }

    public double getRegularOvertime() {
        return regularOvertime;
    }

    public void setRegularOvertime(double regularOvertime) {
        this.regularOvertime = regularOvertime;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public double getRegularMonday() {
        return regularMonday;
    }

    public void setRegularMonday(double regularMonday) {
        this.regularMonday = regularMonday;
    }

    public double getLeaveWithoutPayMonday() {
        return leaveWithoutPayMonday;
    }

    public void setLeaveWithoutPayMonday(double leaveWithoutPayMonday) {
        this.leaveWithoutPayMonday = leaveWithoutPayMonday;
    }

    public double getAnnualLeaveMonday() {
        return annualLeaveMonday;
    }

    public void setAnnualLeaveMonday(double annualLeaveMonday) {
        this.annualLeaveMonday = annualLeaveMonday;
    }

    public double getCompTimeEarnedMonday() {
        return compTimeEarnedMonday;
    }

    public void setCompTimeEarnedMonday(double compTimeEarnedMonday) {
        this.compTimeEarnedMonday = compTimeEarnedMonday;
    }

    public double getCompTimeUsedMonday() {
        return compTimeUsedMonday;
    }

    public void setCompTimeUsedMonday(double compTimeUsedMonday) {
        this.compTimeUsedMonday = compTimeUsedMonday;
    }


    public double getHolidayWorkedMonday() {
        return holidayWorkedMonday;
    }

    public void setHolidayWorkedMonday(double holidayWorkedMonday) {
        this.holidayWorkedMonday = holidayWorkedMonday;
    }

    public double getRegularOvertimeMonday() {
        return regularOvertimeMonday;
    }

    public void setRegularOvertimeMonday(double regularOvertimeMonday) {
        this.regularOvertimeMonday = regularOvertimeMonday;
    }

    public double getHolidayOvertimeMonday() {
        return holidayOvertimeMonday;
    }

    public void setHolidayOvertimeMonday(double holidayOvertimeMonday) {
        this.holidayOvertimeMonday = holidayOvertimeMonday;
    }

    public double getRegularTuesday() {
        return regularTuesday;
    }

    public void setRegularTuesday(double regularTuesday) {
        this.regularTuesday = regularTuesday;
    }

    public double getLeaveWithoutPayTuesday() {
        return leaveWithoutPayTuesday;
    }

    public void setLeaveWithoutPayTuesday(double leaveWithoutPayTuesday) {
        this.leaveWithoutPayTuesday = leaveWithoutPayTuesday;
    }

    public double getAnnualLeaveTuesday() {
        return annualLeaveTuesday;
    }

    public void setAnnualLeaveTuesday(double annualLeaveTuesday) {
        this.annualLeaveTuesday = annualLeaveTuesday;
    }

    public double getCompTimeEarnedTuesday() {
        return compTimeEarnedTuesday;
    }

    public void setCompTimeEarnedTuesday(double compTimeEarnedTuesday) {
        this.compTimeEarnedTuesday = compTimeEarnedTuesday;
    }

    public double getCompTimeUsedTuesday() {
        return compTimeUsedTuesday;
    }

    public void setCompTimeUsedTuesday(double compTimeUsedTuesday) {
        this.compTimeUsedTuesday = compTimeUsedTuesday;
    }



    public double getHolidayWorkedTuesday() {
        return holidayWorkedTuesday;
    }

    public void setHolidayWorkedTuesday(double holidayWorkedTuesday) {
        this.holidayWorkedTuesday = holidayWorkedTuesday;
    }

    public double getRegularOvertimeTuesday() {
        return regularOvertimeTuesday;
    }

    public void setRegularOvertimeTuesday(double regularOvertimeTuesday) {
        this.regularOvertimeTuesday = regularOvertimeTuesday;
    }

    public double getHolidayOvertimeTuesday() {
        return holidayOvertimeTuesday;
    }

    public void setHolidayOvertimeTuesday(double holidayOvertimeTuesday) {
        this.holidayOvertimeTuesday = holidayOvertimeTuesday;
    }

    public double getRegularWednesday() {
        return regularWednesday;
    }

    public void setRegularWednesday(double regularWednesday) {
        this.regularWednesday = regularWednesday;
    }

    public double getLeaveWithoutPayWednesday() {
        return leaveWithoutPayWednesday;
    }

    public void setLeaveWithoutPayWednesday(double leaveWithoutPayWednesday) {
        this.leaveWithoutPayWednesday = leaveWithoutPayWednesday;
    }

    public double getAnnualLeaveWednesday() {
        return annualLeaveWednesday;
    }

    public void setAnnualLeaveWednesday(double annualLeaveWednesday) {
        this.annualLeaveWednesday = annualLeaveWednesday;
    }

    public double getCompTimeEarnedWednesday() {
        return compTimeEarnedWednesday;
    }

    public void setCompTimeEarnedWednesday(double compTimeEarnedWednesday) {
        this.compTimeEarnedWednesday = compTimeEarnedWednesday;
    }

    public double getCompTimeUsedWednesday() {
        return compTimeUsedWednesday;
    }

    public void setCompTimeUsedWednesday(double compTimeUsedWednesday) {
        this.compTimeUsedWednesday = compTimeUsedWednesday;
    }


    public double getHolidayWorkedWednesday() {
        return holidayWorkedWednesday;
    }

    public void setHolidayWorkedWednesday(double holidayWorkedWednesday) {
        this.holidayWorkedWednesday = holidayWorkedWednesday;
    }

    public double getRegularOvertimeWednesday() {
        return regularOvertimeWednesday;
    }

    public void setRegularOvertimeWednesday(double regularOvertimeWednesday) {
        this.regularOvertimeWednesday = regularOvertimeWednesday;
    }

    public double getHolidayOvertimeWednesday() {
        return holidayOvertimeWednesday;
    }

    public void setHolidayOvertimeWednesday(double holidayOvertimeWednesday) {
        this.holidayOvertimeWednesday = holidayOvertimeWednesday;
    }

    public double getRegularThursday() {
        return regularThursday;
    }

    public void setRegularThursday(double regularThursday) {
        this.regularThursday = regularThursday;
    }

    public double getLeaveWithoutPayThursday() {
        return leaveWithoutPayThursday;
    }

    public void setLeaveWithoutPayThursday(double leaveWithoutPayThursday) {
        this.leaveWithoutPayThursday = leaveWithoutPayThursday;
    }

    public double getAnnualLeaveThursday() {
        return annualLeaveThursday;
    }

    public void setAnnualLeaveThursday(double annualLeaveThursday) {
        this.annualLeaveThursday = annualLeaveThursday;
    }

    public double getCompTimeEarnedThursday() {
        return compTimeEarnedThursday;
    }

    public void setCompTimeEarnedThursday(double compTimeEarnedThursday) {
        this.compTimeEarnedThursday = compTimeEarnedThursday;
    }

    public double getCompTimeUsedThursday() {
        return compTimeUsedThursday;
    }

    public void setCompTimeUsedThursday(double compTimeUsedThursday) {
        this.compTimeUsedThursday = compTimeUsedThursday;
    }


    public double getHolidayWorkedThursday() {
        return holidayWorkedThursday;
    }

    public void setHolidayWorkedThursday(double holidayWorkedThursday) {
        this.holidayWorkedThursday = holidayWorkedThursday;
    }

    public double getRegularOvertimeThursday() {
        return regularOvertimeThursday;
    }

    public void setRegularOvertimeThursday(double regularOvertimeThursday) {
        this.regularOvertimeThursday = regularOvertimeThursday;
    }

    public double getHolidayOvertimeThursday() {
        return holidayOvertimeThursday;
    }

    public void setHolidayOvertimeThursday(double holidayOvertimeThursday) {
        this.holidayOvertimeThursday = holidayOvertimeThursday;
    }

    public double getRegularFriday() {
        return regularFriday;
    }

    public void setRegularFriday(double regularFriday) {
        this.regularFriday = regularFriday;
    }

    public double getLeaveWithoutPayFriday() {
        return leaveWithoutPayFriday;
    }

    public void setLeaveWithoutPayFriday(double leaveWithoutPayFriday) {
        this.leaveWithoutPayFriday = leaveWithoutPayFriday;
    }

    public double getAnnualLeaveFriday() {
        return annualLeaveFriday;
    }

    public void setAnnualLeaveFriday(double annualLeaveFriday) {
        this.annualLeaveFriday = annualLeaveFriday;
    }

    public double getCompTimeEarnedFriday() {
        return compTimeEarnedFriday;
    }

    public void setCompTimeEarnedFriday(double compTimeEarnedFriday) {
        this.compTimeEarnedFriday = compTimeEarnedFriday;
    }

    public double getCompTimeUsedFriday() {
        return compTimeUsedFriday;
    }

    public void setCompTimeUsedFriday(double compTimeUsedFriday) {
        this.compTimeUsedFriday = compTimeUsedFriday;
    }



    public double getHolidayWorkedFriday() {
        return holidayWorkedFriday;
    }

    public void setHolidayWorkedFriday(double holidayWorkedFriday) {
        this.holidayWorkedFriday = holidayWorkedFriday;
    }

    public double getRegularOvertimeFriday() {
        return regularOvertimeFriday;
    }

    public void setRegularOvertimeFriday(double regularOvertimeFriday) {
        this.regularOvertimeFriday = regularOvertimeFriday;
    }

    public double getHolidayOvertimeFriday() {
        return holidayOvertimeFriday;
    }

    public void setHolidayOvertimeFriday(double holidayOvertimeFriday) {
        this.holidayOvertimeFriday = holidayOvertimeFriday;
    }

    public double getWeekTotal() {
        return weekTotal;
    }

    public void setWeekTotal(double weekTotal) {
        this.weekTotal = weekTotal;
    }




    public User getEmployee() {
        return employee;
    }

    public void setEmployee(com.example.springboot_security403.User employee) {
        this.employee = employee;
    }

    public void calcWeekPay(double salary) {


        regular = regularMonday + regularTuesday + regularWednesday + regularThursday + regularFriday;
        annualLeave = annualLeaveMonday + annualLeaveTuesday + annualLeaveThursday + annualLeaveWednesday + annualLeaveFriday;
        holidayWorked = holidayWorkedMonday + holidayWorkedTuesday + holidayWorkedWednesday + holidayWorkedThursday + holidayWorkedFriday;
        holidayOvertime = holidayOvertimeMonday + holidayOvertimeTuesday + holidayOvertimeWednesday + holidayOvertimeThursday + holidayOvertimeFriday;
        regularOvertime = regularOvertimeMonday + regularOvertimeTuesday + regularOvertimeWednesday + regularOvertimeThursday + regularOvertimeFriday;



        totalHours = regular + annualLeave + holidayWorked + holidayOvertime + regularOvertime;
        setTotalHours(totalHours);



        //convert hours into money
        regular = regular * salary;
        setRegular(regular);
        regularOvertime = regularOvertime * salary * 1.5;

        holidayWorked = holidayWorked * salary * 1.5;
        setHolidayWorked(holidayWorked);
        holidayOvertime = holidayOvertime * salary * 2.0;
        setHolidayOvertime(holidayOvertime);
        annualLeave = annualLeave * salary;
        setAnnualLeave(annualLeave);

        weekTotal = regular + regularOvertime + holidayWorked + holidayOvertime + annualLeave;

        setWeekTotal(weekTotal);
    }

    public double compTime () {

        return 0;
    }


    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public boolean isHolidayMonday() {
        return holidayMonday;
    }

    public void setHolidayMonday(boolean holidayMonday) {
        this.holidayMonday = holidayMonday;
    }

    public boolean isHolidayTuesday() {
        return holidayTuesday;
    }

    public void setHolidayTuesday(boolean holidayTuesday) {
        this.holidayTuesday = holidayTuesday;
    }

    public boolean isHolidayWednesday() {
        return holidayWednesday;
    }

    public void setHolidayWednesday(boolean holidayWednesday) {
        this.holidayWednesday = holidayWednesday;
    }

    public boolean isHolidayThursday() {
        return holidayThursday;
    }

    public void setHolidayThursday(boolean holidayThursday) {
        this.holidayThursday = holidayThursday;
    }

    public boolean isHolidayFriday() {
        return holidayFriday;
    }

    public void setHolidayFriday(boolean holidayFriday) {
        this.holidayFriday = holidayFriday;
    }
}


