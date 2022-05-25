package com.zucc.Service;


import com.zucc.Exception.EchoServiceException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
public interface StudentService {
    /**
     * 注册
     * @param student
     * @return
     * @throws EchoServiceException
     */
    boolean register(@RequestBody Map<String, String> student) throws EchoServiceException;
    /**
     * 密码登录
     * @param student
     * @return
     * @throws EchoServiceException
     */

    boolean login(@RequestBody Map<String, String> student) throws EchoServiceException;
    /**
     * 修改密码
     * @param student
     * @return
     * @throws EchoServiceException
     */
    boolean modifyPwd(@RequestBody Map<String, String> student) throws EchoServiceException;
    /**
     * 修改个人信息
     * @param student
     * @return
     * @throws EchoServiceException
     */
    boolean modifyInfo(@RequestBody Map<String, String> student) throws EchoServiceException;
    /**
     * 删除
     * @param student
     * @return
     * @throws EchoServiceException
     */
    boolean delete(@RequestBody Map<String, String> student) throws EchoServiceException;
}
