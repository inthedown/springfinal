package com.zucc.Service;

import com.zucc.Entity.Question;
import com.zucc.Form.QuestionDto;

public interface QuestionBankService {

    Question addQuestion(QuestionDto questionDto);

    void changeQuestion(QuestionDto questionDto);

    void deleteQuestion(int id);

    void searchQuestion(String courseName);
}
