package com.efrei.st2ee.dao;

import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * persisting student instance to database
     *
     * @Parame: [student]
     **/
    void insertStudent(Student student);

    /**
     * update student instance
     *
     * @Parame: [student]
     **/
    int updateStudent(Student student);

    /**
     * update student instance
     *
     * @Parame: [student]
     **/
    int updateStudentInternship(StudentInternshipExecution internshipExecution);

    /**
     * get all students the tutor occupied from database
     *
     * @Parame: [student]
     **/
    List<Student> selectAllStudents(Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @Parame: sId : id of student
     * @Parame: tid : id of tutor
     **/
    Student selectStudent(Integer sId, Integer tId);


    /**
     * search student by verify occurrence of keyword in first name or last name
     *
     * @Parame: keyWord
     * @Parame: tId : id of tutor
     **/
    List<Student> selectStudentsByKeyWord(String keyWord, Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @Parame: year
     * @Parame: tid
     **/
    List<Student> selectStudentsByYear(Integer year, Integer tId);

//    /**
//     * get a student of tutor from database by id
//     *
//     * @Parame: year
//     * @Parame: tid
//     **/
//    List<Student> selectStudentsByGroup(String group, Integer tId);

    /**
     * remove student from database
     *
     * @Parame: sId : id of student
     * @Parame: tid : id of tutor
     **/
    int deleteStudent(Integer sId, Integer tId);
}
