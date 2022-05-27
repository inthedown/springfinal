package com.zucc.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Question", schema = "final")
public class Question {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "courseName")
    private String courseName;
}
