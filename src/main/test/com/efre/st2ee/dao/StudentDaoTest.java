package com.efre.st2ee.dao;


import com.efrei.st2ee.dao.StudentDao;
import com.efrei.st2ee.enums.GroupStateEnum;
import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.entity.Tutor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 00:08
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentDaoTest  {
    @Autowired
    StudentDao studentDao;


    @Test
    public void insertTest(){
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
        studentDao.insertStudent(student);
    }

    @Test
    public void updateTest(){

        Student student1 = studentDao.selectStudent(19,1);

        student1.setStudentGroup("M2");
        student1.setFirstName("Li");
        student1.setLastName("LOND");
        studentDao.updateStudent(student1);
    }

    @Test
    public void getAllTest(){
        List<Student> list = studentDao.selectAllStudents(1);
        list.forEach(student -> System.out.println(student.getTutor().getTId()));
        Assert.assertEquals(list.size(),4);
    }

    @Test
    public void getTest(){
        Student student = studentDao.selectStudent(20, 1);
        System.out.println(student);
    }

    @Test
    public void getStudentByKeyWordTest(){
        List<Student> students = studentDao.selectStudentsByKeyWord("l3",1);
        students.forEach(System.out::println);
        Assert.assertEquals(students.size(),2);
    }

    @Test
    public void getStudentsByYearTest(){
        List<Student> students = studentDao.selectStudentsByYear(2020, 1);
        students.forEach(System.out::println);
        Assert.assertEquals(students.size(),5);
    }

    @Test
    public void deleteTest(){
        int res = studentDao.deleteStudent(20, 1);
        Assert.assertEquals(res,1);
    }
}
