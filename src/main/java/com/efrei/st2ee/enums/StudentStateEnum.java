package com.efrei.st2ee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 12:23
 **/


@Getter
public enum  StudentStateEnum {
    NULLSTUDENT(-2,"STUDENT NULL"),NOSTUDENT(-1,"STUDENT NOT EXIST"),FOUND(1,"STUDENT FOUND"),MODIFIED(2,"MODIFICATION SUCCESSED"),
    FAILMODIFIED(-3,"MODIFICATION FAILED"),ADDFAILED(-4,"ADD FAILED"),ADDSUCCESS(3,"ADD SUCCESSED");

    StudentStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    private int state;
    private String stateInfo;

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
