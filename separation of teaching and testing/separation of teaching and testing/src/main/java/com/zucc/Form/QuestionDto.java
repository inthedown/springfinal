package com.zucc.Form;

import lombok.Data;

import java.io.Serializable;
@Data
public class QuestionDto implements Serializable {
//    "title":"这题难不难",
//            "questionType":"单选题",
//            "courseName":"计算机网络",
//            "selections":["难","简单","一般"]
    private final int id;
    private final String title;
    private final String questionType;
    private final String courseName;
    private final String[] selections;
    private final String[] answer;


}
