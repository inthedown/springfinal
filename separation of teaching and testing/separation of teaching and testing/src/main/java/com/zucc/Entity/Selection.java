package com.zucc.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Selection", schema = "final")
public class Selection {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "questionId")
    private int questionId;
    @Basic
    @Column(name = "context")
    private String context;

}
