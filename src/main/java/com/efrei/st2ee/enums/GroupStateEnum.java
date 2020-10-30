package com.efrei.st2ee.enums;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum GroupStateEnum {
    L1("L1"),L2("L2"),L3("L3"),L3NEW("L3NEW"),M1("M1"),M2("M2");

    private String groupInfo;

    public void setGroupInfo(String groupInfo) {
        this.groupInfo = groupInfo;
    }

    public static List<String> getAllGroup(){
        return Lists.newArrayList(L1.groupInfo,L2.groupInfo, L3.getGroupInfo(),M1.groupInfo,M2.groupInfo);
    }
}
