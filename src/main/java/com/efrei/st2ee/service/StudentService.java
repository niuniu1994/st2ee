package com.efrei.st2ee.service;


import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getSearchResult(String keyWord,Integer tId);


    StudentExecution modifyStudentInternship(List<StudentInternshipExecution> internshipExecutionList);
    /**
     * modify student
     *@Parame: [student]
    **/
    StudentExecution modifyStudent(Student student);

    /**
     * add a student into database
     *@Parame: [student]
     **/
    StudentExecution addStudent(Student student);

    /**
     * get all students
     *@Parame: tid tutor id
     **/
    List<Student> getAllStudents(Integer tId);

    /**
     * get a student from database
     *@Parame: [student]
     **/
    Student getStudent(Integer sId,Integer tId);

    List<String> getGroupInfo();
}
