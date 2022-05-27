package com.zucc.Repository;

import com.zucc.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    @Query(value="delete from answer where question_id=:id",nativeQuery = true)
    void deleteByQId(@Param("id") int id);
    @Query(value="select * from answer where question_id=:id",nativeQuery = true)
    List<Answer> findAllByQuestionId(int id);
}
