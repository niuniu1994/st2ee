package com.efrei.st2ee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 14:31
 **/
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentInternshipExecution {
    @JsonFormat(pattern = "studentId")
    private int studentId;
    @JsonFormat(pattern = "nameList")
    private List<String> nameList;
    @JsonFormat(pattern = "checkedList")
    private List<Boolean> checkedList;

}
