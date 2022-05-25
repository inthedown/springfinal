package com.zucc.Controller;

import com.zucc.Repository.TeacherRepository;
import com.zucc.Result.ExceptionMsg;
import com.zucc.Result.ResponseData;
import com.zucc.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    //todo 注册
    @RequestMapping(value = "register",method = RequestMethod.POST)
    ResponseData register(@RequestBody Map<String, String> abody) {
        if(teacherService.register(abody)){
            return new ResponseData(ExceptionMsg.SUCCESS);
        }else{
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
    //todo 密码登录
    @RequestMapping(value = "login",method = RequestMethod.POST)
    ResponseData login(@RequestBody Map<String, String> abody) {
        if (teacherService.login(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }

    //todo 修改密码
    @RequestMapping(value = "modifyPwd",method = RequestMethod.POST)
    ResponseData modifyPwd(@RequestBody Map<String, String> abody) {
        if (teacherService.modifyPwd(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
    //todo 删除
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    ResponseData delete(@RequestBody Map<String, String> abody) {
        if (teacherService.deleteTeacher(abody)) {
            return new ResponseData(ExceptionMsg.SUCCESS);
        } else {
            return new ResponseData(ExceptionMsg.FAILED);
        }
    }
}
