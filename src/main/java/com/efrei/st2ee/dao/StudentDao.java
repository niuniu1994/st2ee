package com.efrei.st2ee.dao;

import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * persisting student instance to database
     *
     * @Parame: {@link Student}
     **/
    void insertStudent(Student student);

    /**
     * update student instance
     *
     * @Parame: {@link Student}
     **/
    int updateStudent(Student student);

    /**
     * update student instance
     *
     * @Parame: {@link Student}
     * @return amount of updated rows
     **/
    int updateStudentInternship(StudentInternshipExecution internshipExecution);

    /**
     * get all students the tutor occupied from database
     *
     * @Parame: {@link Student}
     * @return list of student
     **/
    List<Student> selectAllStudents(Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @Parame: sId : id of student
     * @Parame: tid : id of tutor
     * @return {@link Student}
     **/
    Student selectStudent(Integer sId, Integer tId);


    /**
     * search student by verify occurrence of keyword in first name or last name
     *
     * @Parame: keyWord
     * @Parame: tId : id of tutor
     * @return  list of student
     **/
    List<Student> selectStudentsByKeyWord(String keyWord, Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @Parame: year
     * @Parame: tid
     * @return list of students
     **/
    List<Student> selectStudentsByYear(Integer year, Integer tId);

    /**
     * remove student from database
     *
     * @Parame: sId : id of student
     * @Parame: tid : id of tutor
     * @return amount of deleted row
     **/
    int deleteStudent(Integer sId, Integer tId);
}
