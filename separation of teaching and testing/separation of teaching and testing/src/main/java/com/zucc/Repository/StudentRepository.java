package com.zucc.Repository;

import com.zucc.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select pwd from Student WHERE stu_no = :sno", nativeQuery = true)
    String searchPwd(@Param("sno") String sno);

    @Query(value = "select * from Student WHERE name = :name", nativeQuery = true)
    Map<String, String> searchInfo(@Param("name") String name);
    @Transactional
    @Modifying
    @Query(value = "update Student set pwd = :pwd where stu_no =:sno", nativeQuery = true)
    void changePwd(@Param("sno") String sno,@Param("pwd") String pwd);
    @Modifying
    @Query(value = "update stu_course set course_name = :course where stu_no =:sno", nativeQuery = true)
    void changeInfo(@Param("course") String course,@Param("sno") String sno);
    void deleteBySno(@Param("sno") String sno);
    @Query(value = "select * from questionnaire where classname in (select college from student where name=:student_name)",nativeQuery = true)
    List<Map> findforcourse(@Param("student_name")String student_name);
    @Modifying
    @Query(value = "delete from stu_course where stu_no=:sno",nativeQuery = true)
    void deleteAllBySno(@Param("sno") String sno);

    @Modifying
    @Query(value = "insert into stu_course(stu_no,stu_name,course_name) values(?,?,?)",nativeQuery = true)
    void saveCourse(@Param("sno") String sno,@Param("name") String name,@Param("course")String course);
}
