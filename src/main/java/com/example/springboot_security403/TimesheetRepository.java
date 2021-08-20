package com.example.springboot_security403;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
    Iterable<Timesheet> findAllByStage(String stage);
    Iterable<Timesheet> findAllByEmployee(User employee);
    Iterable<Timesheet> findAllByDateBefore(LocalDate date);
 }
