package com.zucc.Service.impl;

import com.zucc.Entity.Question;
import com.zucc.Form.QuestionDto;
import com.zucc.Repository.QuestionBankRepository;
import com.zucc.Service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionBankImpl implements QuestionBankService {
    @Autowired
    private QuestionBankRepository questionBankRepository;
    @Override
    public Question addQuestion(QuestionDto questionDto) {
        Question aquestion = new Question();
        aquestion.setCourseName(questionDto.getCourseName());
        aquestion.setTitle(questionDto.getTitle());
        aquestion.setType(questionDto.getQuestionType());
        Question bquestion=questionBankRepository.save(aquestion);
        return bquestion;
    }

    @Override
    public void changeQuestion(QuestionDto questionDto) {

    }

    @Override
    public void deleteQuestion(int id) {

    }

    @Override
    public void searchQuestion(String courseName) {

    }
}
