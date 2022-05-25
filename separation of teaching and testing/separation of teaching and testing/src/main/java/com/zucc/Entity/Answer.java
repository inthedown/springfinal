package com.zucc.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Answer", schema = "javaeee")
public class Answer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "questionId")
    private int questionId;
    @Basic
    @Column(name = "selectionId")
    private int selectionId;

}
