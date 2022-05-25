package com.zucc.Controller;

import com.zucc.Entity.Student;
import com.zucc.Repository.StudentRepository;
import com.zucc.Result.ExceptionMsg;
import com.zucc.Result.ResponseData;
import com.zucc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {
    public List<Student> students;//所有学生
    @Resource
    private StudentService studentService;

    //todo register
    @RequestMapping("/register")
    ResponseData register(@RequestBody Map<String, String> abody) {
        if(studentService.register(abody)){
            return new ResponseData(ExceptionMsg.SUCCESS);
        }else{
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
//    //todo 密码登录
    @RequestMapping("/login")
    ResponseData login(@RequestBody Map<String, String> abody) {
        if (studentService.login(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
//
    //todo 修改密码
    @RequestMapping("/modifyPwd")
    ResponseData modifyPwd(@RequestBody Map<String, String> abody) {
        if (studentService.modifyPwd(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
//
//    //todo 修改个人信息
    @RequestMapping("/modifyInfo")
    ResponseData modifyInfo(@RequestBody Map<String, String> abody) {
        if (studentService.modifyInfo(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
//
//    //todo 删除
    @RequestMapping("/delete")
    ResponseData delete(@RequestBody Map<String, String> abody) {
        if (studentService.delete(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
}
