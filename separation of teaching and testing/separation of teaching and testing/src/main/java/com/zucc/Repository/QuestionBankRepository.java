package com.zucc.Repository;

import com.zucc.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionBankRepository extends JpaRepository<Question,Integer> {

}
