package com.zucc.Repository;

import com.zucc.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "select pwd from Teacher where tno = :tno")
    String searchPwd(@Param("tno") String tno);
    @Query(value = "select name from Teacher ")
    List<String> findTeacherNames();
    @Transactional
    @Modifying
    @Query(value = "insert into teacher_course(tno,tea_name,course_name) values(?,?,?)",nativeQuery = true)
    void saveCourse(@Param("tno") String tno,@Param("name") String name,@Param("course")String course);
    @Transactional
    @Modifying
    @Query(value = "update Teacher set pwd = :pwd where tno =:tno",nativeQuery = true)
    void changePwd(@Param("tno") String tno,@Param("pwd") String pwd);
    @Transactional
    @Modifying
    @Query(value = "delete from Teacher where tno=:tno",nativeQuery = true)
    void deleteByTno(@Param("tno") String tno);
    @Transactional
    @Modifying
    @Query(value = "delete from teacher_course where tno=:tno",nativeQuery = true)
    void deleteAllByTno(@Param("tno") String tno);
}
