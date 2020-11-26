package com.efrei.st2ee.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @program: ST2EE
 * @description: student state
 * @author: xin
 * @create: 2020-10-25 12:23
 **/
@AllArgsConstructor
@Getter
public enum StudentStateEnum {
    NULLSTUDENT(-2, "STUDENT NULL"), NOSTUDENT(-1, "STUDENT NOT EXIST"), FOUND(1, "STUDENT FOUND"), MODIFIED(2, "MODIFICATION SUCCESSED"),
    FAILMODIFIED(-3, "MODIFICATION FAILED"), ADDFAILED(-4, "ADD FAILED"), ADDSUCCESS(3, "ADD SUCCESSED");

    private int state;
    private String stateInfo;
}
