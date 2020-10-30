package com.efrei.st2ee.dto;

import com.efrei.st2ee.enums.*;
import com.efrei.st2ee.entity.Student;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 12:14
 **/

@Getter
@Setter
@NoArgsConstructor
public class StudentExecution {
    private int state;
    private String stateInfo;

    private Student student;

    private List<Student> studentList;

    public StudentExecution(StudentStateEnum studentStateEnum) {
        state =studentStateEnum.getState();
        stateInfo = studentStateEnum.getStateInfo();
    }


    public StudentExecution(StudentStateEnum studentStateEnum,Student student) {
        state =studentStateEnum.getState();
        stateInfo = studentStateEnum.getStateInfo();
        this.student = student;
    }


    public StudentExecution(StudentStateEnum studentStateEnum,List<Student> studentList) {
        state =studentStateEnum.getState();
        stateInfo = studentStateEnum.getStateInfo();
        this.studentList = studentList;
    }

}
