package com.example.Employee.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Employee_Details")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_Id")
    private long id;

    @Column(name = "Employee_Name")
    private String name;

    @Column(name = "Employee_Age")
    private int age;

    @Column(name = "Employee_MobNo")
    private String mobNo;

    @Column(name = "Employee_Email")
    private String email;

}
