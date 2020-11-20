package com.efrei.st2ee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: ST2EE
 * @description: login status
 * @author: xin
 * @create: 2020-10-25 12:19
 **/
@Getter
@AllArgsConstructor
public enum LoginStateEnum {
    LOGINFAIL(-1, "Password or Username incorrect"), SUCCESS(0, "Login success");

    private int state;
    private String stateInfo;

}
