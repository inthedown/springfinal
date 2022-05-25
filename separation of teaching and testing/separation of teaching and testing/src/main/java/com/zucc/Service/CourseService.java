package com.zucc.Service;

import com.zucc.Exception.EchoServiceException;
import com.zucc.Form.CourseDto;

import java.util.Map;

public interface CourseService {
    /**
     * 创建课程
     * @param courseDto
     * @return
     * @throws EchoServiceException
     */
    Integer createClass(CourseDto courseDto) throws EchoServiceException;
    /**
     * 结束课程
     * @param courseDto
     * @return
     * @throws EchoServiceException
     */
    Integer endClass(CourseDto courseDto) throws EchoServiceException;
    /**
     * 删除课程
     * @param courseDto
     * @return
     * @throws EchoServiceException
     */
    Integer deleteClass(CourseDto courseDto) throws EchoServiceException;
//    /**
//     * 授课教师管理
//     * @param courseDto
//     * @return
//     * @throws EchoServiceException
//     */
//    Integer teacherManage(CourseDto courseDto) throws EchoServiceException;
}
