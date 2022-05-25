package com.zucc.Form;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
@Data
public class CourseDto implements Serializable {
    private int id;//课程id
    private String course_name;//课程名称
    private String area;//授课教室
    private String schooltime;//课程时间
    private String teacher_name;//老师名字
    private String create_date;//课程创建时间
    private String end_date;//课程结束时间
    private String status;//课程状态
}
