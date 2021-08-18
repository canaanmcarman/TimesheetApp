package com.example.springboot_security403;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private User employee;

    private String actionName;

    private Date date;
}
