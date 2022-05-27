package com.zucc.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student" ,schema="final")
public class Student {
    private int s_id;//学生的编号
    private String sno;//学生学号
    private String name;//学生姓名
    private String pwd;//密码
    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    @Basic
    @Column(name = "stu_no")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
