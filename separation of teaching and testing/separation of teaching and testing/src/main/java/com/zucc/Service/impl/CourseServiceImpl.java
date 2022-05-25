package com.zucc.Service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.zucc.Entity.Course;
import com.zucc.Exception.EchoServiceException;
import com.zucc.Form.CourseDto;
import com.zucc.Repository.CourseRepository;
import com.zucc.Repository.TeacherRepository;
import com.zucc.Service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    public List<Course> course;//所有课程
    @Autowired
    private CourseRepository courseRepository;

    //todo 创建课程
    public Integer createClass(CourseDto courseDto) throws EchoServiceException {
        Course aCourse = new Course();
        BeanUtils.copyProperties(courseDto, aCourse);
        System.out.println("内容1："+aCourse);
        System.out.println("内容2："+courseDto);
        aCourse.setName(courseDto.getCourse_name());
        aCourse.setArea(courseDto.getArea());
        aCourse.setCreateDate(courseDto.getCreate_date());
        aCourse.setEndDate(courseDto.getEnd_date());
        aCourse.setTime(courseDto.getSchooltime());
        aCourse.setTeacherName(courseDto.getTeacher_name());
        aCourse.setStatus("进行中");
        courseRepository.save(aCourse);
        return aCourse.getId();
    }
    //todo 结束课程
    public Integer endClass(CourseDto courseDto) throws EchoServiceException{
        String name= courseDto.getCourse_name();
        String end_date = courseDto.getEnd_date();
        Integer id = courseRepository.findId(name);
        Course aCourse=courseRepository.findById(id).get();
        aCourse.setEndDate(end_date);
        aCourse.setStatus("已结课");
        courseRepository.save(aCourse);
        return id;
    }

    //todo 删除课程
    public  Integer deleteClass(CourseDto courseDto) throws EchoServiceException{
        String name= courseDto.getCourse_name();
        Integer id = courseRepository.findId(name);
        courseRepository.deleteById(id);
        return null;
    }

//    //todo 授课教师管理
//    public Integer teacherManage(CourseDto courseDto) throws EchoServiceException{
//        int teacherId= Integer.parseInt(abody.get("teacherId"));
//        int courseId=Integer.parseInt(abody.get("courseId"));
//        Teacher aTeacher= teacherRepository.findById(teacherId).get();
//        Course aCourse= classRepository.findById(courseId).get();
//        aCourse.setTeacherName(aTeacher.getName());
//        classRepository.save(aCourse);
//        return aCourse.getId();
//    }
}
