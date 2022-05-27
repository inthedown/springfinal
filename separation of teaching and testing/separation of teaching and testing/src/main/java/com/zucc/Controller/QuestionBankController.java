package com.zucc.Controller;

import com.zucc.Entity.Question;
import com.zucc.Form.QuestionDto;
import com.zucc.Result.ExceptionMsg;
import com.zucc.Result.ResponseData;
import com.zucc.Service.QuestionBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questionBank")
public class QuestionBankController {
    private final Logger logger = LoggerFactory.getLogger(QuestionBankController.class);

    @Autowired
    private QuestionBankService questionBankService;

    @RequestMapping(value = "add", method =  RequestMethod.POST)
    @ResponseBody
    public ResponseData addQuestion(@RequestBody QuestionDto questionDto){
        logger.info(questionDto.toString());
        Question aquestion=questionBankService.addQuestion(questionDto);
        return  new ResponseData(ExceptionMsg.SUCCESS,aquestion);
    }
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData deleteQuestion(@RequestParam("questionId") int id){
        questionBankService.deleteQuestion(id);
        return  new ResponseData(ExceptionMsg.SUCCESS,1);
    }
    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData searchQuestion(@RequestParam("courseName")String courseName){
        questionBankService.searchQuestion(courseName);
        return  new ResponseData(ExceptionMsg.SUCCESS,1);
    }
    @RequestMapping(value = "change", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData changeQuestion(@RequestBody QuestionDto questionDto){
        logger.info(questionDto.toString());
        questionBankService.changeQuestion(questionDto);
        return  new ResponseData(ExceptionMsg.SUCCESS,1);
    }

}
