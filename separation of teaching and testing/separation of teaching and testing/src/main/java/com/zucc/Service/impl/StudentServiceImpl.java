package com.zucc.Service.impl;

import com.zucc.Entity.Student;
import com.zucc.Exception.EchoServiceException;
import com.zucc.Repository.StudentRepository;
import com.zucc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    public List<Student> students;//所有学生
    @Resource
    private StudentRepository studentrepository;
    @Override
    public boolean register(Map<String, String> abody) throws EchoServiceException {
        String sno = abody.get("stu_no");
        String name = abody.get("name");
        String pwd = abody.get("pwd");
        String course = abody.get("course");
        if(studentrepository.searchPwd(name)==null){
            Student aStudent = new Student();
            aStudent.setName(name);
            aStudent.setPwd(pwd);
            aStudent.setSno(sno);
            studentrepository.save(aStudent);
            studentrepository.saveCourse(sno,name,course);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean login(Map<String, String> abody) throws EchoServiceException{
        String sno = abody.get("stu_no");
        String pwd = abody.get("pwd");
        if (studentrepository.searchPwd(sno) != null) {
            if (studentrepository.searchPwd(sno).equals(pwd)) return true;
            else return false;
        } else {
            return false;
        }
    }
    @Override
    public boolean modifyPwd(Map<String, String> abody) throws EchoServiceException{
        String sno = abody.get("stu_no");
        String pwd = abody.get("pwd");
        String new_pwd = abody.get("new_pwd");
        if (studentrepository.searchPwd(sno) != null) {
            if (studentrepository.searchPwd(sno).equals(pwd)) {
                studentrepository.changePwd(sno,new_pwd);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    @Override
    public boolean modifyInfo(Map<String, String> abody) throws EchoServiceException{
        String sno = abody.get("stu_no");
        String course = abody.get("course");
        studentrepository.changeInfo(course, sno);
        return  true;
    }
    @Override
    public boolean delete(Map<String, String> abody) throws EchoServiceException{
        String sno = abody.get("stu_no");
        if (studentrepository.searchPwd(sno)!= null) {
            studentrepository.deleteBySno(sno);
            studentrepository.deleteAllBySno(sno);
            return  true;
        } else {
            return  false;
        }
    }
}
