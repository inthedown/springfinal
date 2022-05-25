package com.zucc.Repository;

import com.zucc.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "select course_id from course where course_name=:name",nativeQuery = true)
    Integer findId(String name);
}
