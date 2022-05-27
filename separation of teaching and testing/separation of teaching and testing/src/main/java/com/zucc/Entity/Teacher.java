package com.zucc.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher" ,schema="final")
public class Teacher {
    private int t_id;//老师的编号
    private String tno;//老师的工号
    private String name;//老师姓名
    private String pwd;//密码

    @Id
    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    @Basic
    @Column(name = "tno")
    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }
    @Basic
    @Column(name = "tea_name")
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
