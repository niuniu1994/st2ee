package com.efre.st2ee.service;

import com.efrei.st2ee.dao.StudentDao;
import com.efrei.st2ee.dto.StudentExecution;
import com.efrei.st2ee.enums.StudentStateEnum;
import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 18:11
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentDao studentDao;

    @Test
    @Transactional
    public void updateStudentTest() {
        Student student = studentDao.selectStudent(1, 1);
        String baseGroup = student.getStudentGroup();
        String baseFirstName = student.getFirstName();
        String baseLastName = student.getLastName();
        student.setStudentGroup("M2");
        student.setFirstName("LENON");
        student.setLastName("HONG");
        studentService.modifyStudent(student);
        Student studentCreated = studentDao.selectStudent(1, 1);
        student.setStudentGroup(baseGroup);
        student.setFirstName(baseFirstName);
        student.setLastName(baseLastName);
        studentService.modifyStudent(student);
        Assert.assertEquals(student.getFirstName(), studentCreated.getFirstName());
    }

    @Test
    public void addStudentTest() {
        Tutor tutor = new Tutor();
        tutor.setTId(1);
        Student student = new Student();
        student.setAddress("112 BOULEBARD OF JK");
        student.setFirstName("BLUES");
        student.setLastName("LEE");
        student.setCompanyName("WEI");
        student.setCharger("KEVEN");
        student.setStudentGroup("L3");
        student.setTutor(tutor);
        student.setEndDate(LocalDate.now());
        student.setStartDate(LocalDate.now());
        StudentExecution studentExecution = studentService.addStudent(student);
        Assert.assertEquals(StudentStateEnum.ADDSUCCESS.getState(), studentExecution.getState());
        List<Student> listStudent = studentDao.selectAllStudents(1);
        studentDao.deleteStudent(listStudent.get(listStudent.size() - 1).getStudentId(), 1);
    }
}
