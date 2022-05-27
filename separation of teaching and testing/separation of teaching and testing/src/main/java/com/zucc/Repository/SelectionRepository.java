package com.zucc.Repository;

import com.zucc.Entity.Selection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SelectionRepository extends JpaRepository<Selection,Integer> {
    @Query(value="delete from selection where question_id=:id",nativeQuery = true)
    void deleteByQId(@Param(value="id")int id);
    @Query(value="select * from selection where question_id=:id",nativeQuery = true)
    List<Selection> findAllByQuestionId(int id);
}
