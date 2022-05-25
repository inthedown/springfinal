package com.zucc.Service.impl;

import com.zucc.Entity.Teacher;
import com.zucc.Exception.EchoServiceException;
import com.zucc.Repository.TeacherRepository;
import com.zucc.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    //todo 注册
    @Override
    public boolean register(Map<String, String> abody) throws EchoServiceException {
        String tno = abody.get("tno");
        String name = abody.get("name");
        String pwd = abody.get("pwd");
        String course = abody.get("course");
        //System.out.println("课程"+course);
        if(teacherRepository.searchPwd(tno)==null){
//            System.out.println("!!!!");
            Teacher aTeacher = new Teacher();
            aTeacher.setTno(tno);
            aTeacher.setName(name);
            aTeacher.setPwd(pwd);
            teacherRepository.save(aTeacher);
//            System.out.println("tno:"+tno);
//            System.out.println("name:"+name);
//            System.out.println("course:"+course);
//            teacherRepository.saveCourse(tno,name,course);
//            System.out.println("老师"+"suss");
            return true;
        }else {
            return  false;
        }

    }
    //todo 密码登录
    @Override
    public boolean login(Map<String, String> abody) throws EchoServiceException{
        String tno = abody.get("tno");
        String pwd = abody.get("pwd");
        if (teacherRepository.searchPwd(tno) != null) {
            if (teacherRepository.searchPwd(tno).equals(pwd)) return true;
            else return false;
        } else {
            return false;
        }
    }

    //todo 修改密码
    @Override
    public boolean modifyPwd(Map<String, String> abody) throws EchoServiceException{
        String tno = abody.get("tno");
        String pwd = abody.get("pwd");
        String new_pwd = abody.get("new_pwd");
        if (teacherRepository.searchPwd(tno) != null) {
            if (teacherRepository.searchPwd(tno).equals(pwd)) {
                teacherRepository.changePwd(tno, new_pwd);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //todo 删除
    @Override
    public boolean deleteTeacher(Map<String, String> abody) throws EchoServiceException{
        String tno = abody.get("tno");
        if (teacherRepository.searchPwd(tno)!= null) {
            teacherRepository.deleteByTno(tno);
            //teacherRepository.deleteAllByTno(tno);
            return true;
        } else {
            return false;
        }
    }

}
