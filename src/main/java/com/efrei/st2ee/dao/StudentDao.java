package com.efrei.st2ee.dao;

import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * persisting student instance to database
     *
     * @param  {@link Student}
     **/
    boolean insertStudent(Student student);

    /**
     * update student instance
     *
     * @param  student
     **/
    boolean updateStudent(Student student);

    /**
     * update student instance
     *
     * @param internshipExecution
     * @return amount of updated rows
     **/
    boolean updateStudentInternship(StudentInternshipExecution internshipExecution);

    /**
     * get all students the tutor occupied from database
     *
     * @param tId
     * @return list of student
     **/
    List<Student> selectAllStudents(Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @param sId : id of student
     * @param tId : id of tutor
     * @return {@link Student}
     **/
    Student selectStudent(Integer sId, Integer tId);


    /**
     * search student by verify occurrence of keyword in first name or last name
     *
     * @param keyWord
     * @param tId : id of tutor
     * @return  list of student
     **/
    List<Student> selectStudentsByKeyWord(String keyWord, Integer tId);

    /**
     * get a student of tutor from database by id
     *
     * @param year
     * @param tId
     * @return list of students
     **/
    List<Student> selectStudentsByYear(Integer year, Integer tId);

    /**
     * remove student from database
     *
     * @param sId : id of student
     * @param tId : id of tutor
     * @return amount of deleted row
     **/
    boolean deleteStudent(Integer sId, Integer tId);
}
