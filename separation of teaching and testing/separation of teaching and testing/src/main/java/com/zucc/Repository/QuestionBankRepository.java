package com.zucc.Repository;

import com.zucc.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionBankRepository extends JpaRepository<Question,Integer> {
    @Query(value="select * from question where courseName=:courseName",nativeQuery = true)
    List<Question> searchQuestion(String courseName);
}
