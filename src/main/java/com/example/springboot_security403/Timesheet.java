package com.example.springboot_security403;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timesheet")
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User Employee;

    private String payCode;

    //monday
    @Column(name = "regular_monday")
    private double regularMonday;

    @Column(name = "leavewithoutpaymonday")
    private double leaveWithoutPayMonday;

    @Column(name = "annualleavemonday")
    private double annualLeaveMonday;

    @Column(name = "comptimemonday")
    private double compTimeEarnedMonday;

    @Column(name = "comptimeusedmonday")
    private double compTimeUsedMonday;

    @Column(name = "holidaymonday")
    private double holidayMonday;

    @Column(name = "holidayworkedmonday")
    private double holidayWorkedMonday;
    
    @Column(name = "regularovertimemonday")
    private double regularOvertimeMonday;

    @Column(name = "holidayrovertimemonday")
    private double holidayOvertimeMonday;

    //tuesday
    @Column(name = "regular_tuesday")
    private double regularTuesday;

    @Column(name = "leavewithoutpaytuesday")
    private double leaveWithoutPayTuesday;

    @Column(name = "annualleavetuesday")
    private double annualLeaveTuesday;

    @Column(name = "comptimeearnedtuesday")
    private double compTimeEarnedTuesday;

    @Column(name = "comptimeusedtuesday")
    private double compTimeUsedTuesday;

    @Column(name = "holidaytuesday")
    private double holidayTuesday;

    @Column(name = "holidayworedtuesday")
    private double holidayWorkedTuesday;

    @Column(name = "regularovertimetuesday")
    private double regularOvertimeTuesday;

    @Column(name = "holidayovertimetuesday")
    private double holidayOvertimeTuesday;

    //weds
    @Column(name = "regular_wednesday")
    private double regularWednesday;

    @Column(name = "leavewithoutpaywednesday")
    private double leaveWithoutPayWednesday;

    @Column(name = "annualleavewednesday")
    private double annualLeaveWednesday;

    @Column(name = "comptimeearnedpaywednesday")
    private double compTimeEarnedWednesday;

    @Column(name = "comptimeusedwednesday")
    private double compTimeUsedWednesday;

    @Column(name = "holidaywednesday")
    private double holidayWednesday;

    @Column(name = "holidayworkedwednesday")
    private double holidayWorkedWednesday;

    @Column(name = "regularovertimewednesday")
    private double regularOvertimeWednesday;

    @Column(name = "holidayovertimewednesday")
    private double holidayOvertimeWednesday;

    //thurs
    @Column(name = "regular_thursday")
    private double regularThursday;

    @Column(name = "leavewithoutpaythursday")
    private double leaveWithoutPayThursday;

    @Column(name = "annualleavethursday")
    private double annualLeaveThursday;

    @Column(name = "comptimeearnedthursday")
    private double compTimeEarnedThursday;

    @Column(name = "comptimeusedthursday")
    private double compTimeUsedThursday;

    @Column(name = "holidaythursday")
    private double holidayThursday;

    @Column(name = "holidayworkedthursday")
    private double holidayWorkedThursday;

    @Column(name = "regularoverthursday")
    private double regularOvertimeThursday;

    @Column(name = "holidayovertimethursday")
    private double holidayOvertimeThursday;

    //friday
    @Column(name = "regular_friday")
    private double regularFriday;

    @Column(name = "leavewithoutpayfriday")
    private double leaveWithoutPayFriday;

    @Column(name = "annualleavefriday")
    private double annualLeaveFriday;

    @Column(name = "comptimeearnedfriday")
    private double compTimeEarnedFriday;

    @Column(name = "comptimeusedfriday")
    private double compTimeUsedFriday;

    @Column(name = "holidayfriday")
    private double holidayFriday;

    @Column(name = "holidayworkedfriday")
    private double holidayWorkedFriday;

    @Column(name = "regularovertimefriday")
    private double regularOvertimeFriday;

    @Column(name = "holidayoverfriday")
    private double holidayOvertimeFriday;


    private double weekTotal;

    private Date date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.example.springboot_security403.User getEmployee() {
        return Employee;
    }

    public void setEmployee(com.example.springboot_security403.User employee) {
        Employee = employee;
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

    public double getHolidayMonday() {
        return holidayMonday;
    }

    public void setHolidayMonday(double holidayMonday) {
        this.holidayMonday = holidayMonday;
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

    public double getHolidayTuesday() {
        return holidayTuesday;
    }

    public void setHolidayTuesday(double holidayTuesday) {
        this.holidayTuesday = holidayTuesday;
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

    public double getHolidayWednesday() {
        return holidayWednesday;
    }

    public void setHolidayWednesday(double holidayWednesday) {
        this.holidayWednesday = holidayWednesday;
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

    public double getHolidayThursday() {
        return holidayThursday;
    }

    public void setHolidayThursday(double holidayThursday) {
        this.holidayThursday = holidayThursday;
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

    public double getHolidayFriday() {
        return holidayFriday;
    }

    public void setHolidayFriday(double holidayFriday) {
        this.holidayFriday = holidayFriday;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}




