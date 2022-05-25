package com.zucc.Controller;

import com.zucc.Entity.Course;
import com.zucc.Form.CourseDto;
import com.zucc.Result.ExceptionMsg;
import com.zucc.Result.ResponseData;
import com.zucc.Service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("course")
public class CourseController {
    public List<Course> course;//所有课程
    @Autowired
    private CourseService courseService;
    private final Logger logger = LoggerFactory.getLogger(CourseController.class);
    //todo 创建课程
    @RequestMapping(value = "create",method = RequestMethod.POST)
    public ResponseData createClass(@RequestBody CourseDto courseDto) {
        Integer courseId = courseService.createClass(courseDto);
        logger.warn("course {} created",courseId);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }
    //todo 结束课程
    @RequestMapping("end")
    public ResponseData endClass(@RequestBody CourseDto courseDto) {
        Integer courseId = courseService.endClass(courseDto);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }

    //todo 删除课程
    @RequestMapping("delete")
    public ResponseData deleteClass(@RequestBody CourseDto courseDto) {
        courseService.deleteClass(courseDto);
        return new ResponseData(ExceptionMsg.SUCCESS);
    }
}
