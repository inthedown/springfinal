package com.zucc.Service;

import com.zucc.Exception.EchoServiceException;

import java.util.Map;

public interface TeacherService {
    /**
     * 注册
     * @param teacher
     * @return
     * @throws EchoServiceException
     */
    boolean register(Map<String, String> teacher) throws EchoServiceException;
    /**
     * 密码登录
     * @param teacher
     * @return
     * @throws EchoServiceException
     */
    boolean login(Map<String, String> teacher) throws EchoServiceException;
    /**
     * 修改密码
     * @param teacher
     * @return
     * @throws EchoServiceException
     */
    boolean modifyPwd(Map<String, String> teacher) throws EchoServiceException;
    /**
     * 删除
     * @param teacher
     * @return
     * @throws EchoServiceException
     */
    boolean deleteTeacher(Map<String, String> teacher) throws EchoServiceException;
}
