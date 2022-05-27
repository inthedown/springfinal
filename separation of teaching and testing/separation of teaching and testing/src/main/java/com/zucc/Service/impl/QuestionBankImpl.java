package com.zucc.Service.impl;

import com.zucc.Entity.Answer;
import com.zucc.Entity.Question;
import com.zucc.Entity.Selection;
import com.zucc.Form.QuestionDto;
import com.zucc.Repository.AnswerRepository;
import com.zucc.Repository.QuestionBankRepository;
import com.zucc.Repository.SelectionRepository;
import com.zucc.Service.QuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionBankImpl implements QuestionBankService {
    @Autowired
    private QuestionBankRepository questionBankRepository;
    @Autowired
    private SelectionRepository selectionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Question addQuestion(QuestionDto questionDto) {
        Question aquestion = new Question();
        aquestion.setCourseName(questionDto.getCourseName());
        aquestion.setTitle(questionDto.getTitle());
        aquestion.setType(questionDto.getQuestionType());
        Question bquestion=questionBankRepository.save(aquestion);
        int questionId = bquestion.getId();
        String type = questionDto.getQuestionType();
        if(type.equals("单选")||type.equals("填空")||type.equals("判断")){
            String[] selections=questionDto.getSelections();
            String[] answers = questionDto.getAnswer();
            for (String selection : selections) {
                Selection aselection=new Selection();
                aselection.setQuestionId(questionId);
                aselection.setContext(selection);
                Selection bselection=selectionRepository.save(aselection);
                if(answers!=null){
                    if(selection.equals(answers[0])){
                        Answer aanswer=new Answer();
                        aanswer.setQuestionId(questionId);
                        aanswer.setSelectionId(bselection.getId());
                        answerRepository.save(aanswer);
                    }
                }

            }
        }else if(type.equals("多选")){
            String[] selections=questionDto.getSelections();
            String[] answers = questionDto.getAnswer();
            for (String selection : selections) {
                Selection aselection=new Selection();
                aselection.setQuestionId(questionId);
                aselection.setContext(selection);
                Selection bselection=selectionRepository.save(aselection);
                for(String answer :answers) {
                    if (selection.equals(answer)) {
                        Answer aanswer = new Answer();
                        aanswer.setQuestionId(questionId);
                        aanswer.setSelectionId(bselection.getId());
                        answerRepository.save(aanswer);
                    }
                }
            }
        }

        return bquestion;
    }

    @Override
    public void changeQuestion(QuestionDto questionDto) {
        Question aquestion = new Question();
        aquestion.setId(questionDto.getId());
        aquestion.setCourseName(questionDto.getCourseName());
        aquestion.setTitle(questionDto.getTitle());
        aquestion.setType(questionDto.getQuestionType());
        Question bquestion=questionBankRepository.save(aquestion);
        int questionId = bquestion.getId();
        String type = questionDto.getQuestionType();
        if(type.equals("单选")||type.equals("填空")||type.equals("判断")){
            String[] selections=questionDto.getSelections();
            String[] answers = questionDto.getAnswer();
            for (String selection : selections) {
                Selection aselection=new Selection();
                aselection.setQuestionId(questionId);
                aselection.setContext(selection);
                Selection bselection=selectionRepository.save(aselection);
                if(answers!=null){
                    if(selection.equals(answers[0])){
                        Answer aanswer=new Answer();
                        aanswer.setQuestionId(questionId);
                        aanswer.setSelectionId(bselection.getId());
                        answerRepository.save(aanswer);
                    }
                }
            }
        }else if(type.equals("多选")) {
            String[] selections = questionDto.getSelections();
            String[] answers = questionDto.getAnswer();
            for (String selection : selections) {
                Selection aSelection = new Selection();
                aSelection.setQuestionId(questionId);
                aSelection.setContext(selection);
                Selection bSelection = selectionRepository.save(aSelection);
                for (String answer : answers) {
                    if (selection.equals(answer)) {
                        Answer aanswer = new Answer();
                        aanswer.setQuestionId(questionId);
                        aanswer.setSelectionId(bSelection.getId());
                        answerRepository.save(aanswer);
                    }
                }
            }
        }
    }

    @Override
    public void deleteQuestion(int id) {
        System.out.println(answerRepository.findAllByQuestionId(id).size());
        if(answerRepository.findAllByQuestionId(id).size() > 0) {
            answerRepository.deleteByQId(id);
        }
        if(selectionRepository.findAllByQuestionId(id).size() > 0){
            selectionRepository.deleteByQId(id);
        }
        if(!questionBankRepository.findById(id).isEmpty()){
            questionBankRepository.deleteById(id);
        }

    }

    @Override
    public void searchQuestion(String courseName) {
       List<Question> questions= questionBankRepository.searchQuestion(courseName);
       System.out.println(questions);
    }
}
