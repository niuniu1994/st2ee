package com.efrei.st2ee.service.impl;

import com.efrei.st2ee.dao.StudentDao;
import com.efrei.st2ee.dto.StudentExecution;
import com.efrei.st2ee.dto.StudentInternshipExecution;
import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.enums.GroupStateEnum;
import com.efrei.st2ee.enums.StudentStateEnum;
import com.efrei.st2ee.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Resource;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 12:07
 **/

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    //@Resource(name="studentDao")
    @Resource(name = "jdbcStudentDao")
    private StudentDao studentDao;


    @Override
    public List<Student> getSearchResult(String keyWord, Integer tId) {
        List<Student> studentList = new ArrayList<>();
        keyWord = keyWord.trim();
        if (isNumeric(keyWord)) {
            studentList = studentDao.selectStudentsByYear(Integer.parseInt(keyWord), tId);
        } else {
            studentList = studentDao.selectStudentsByKeyWord(keyWord, tId);
        }
        return studentList;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StudentExecution modifyStudentInternship(List<StudentInternshipExecution> internshipExecutionList) throws RuntimeException {
        try {
            internshipExecutionList.forEach(studentDao::updateStudentInternship);
            return new StudentExecution(StudentStateEnum.MODIFIED);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StudentExecution modifyStudent(Student student) throws RuntimeException {
        StudentExecution studentExecution = new StudentExecution();
        Student student1;
        if (student != null && student.getStudentId() != null && student.getTutor() != null && student.getTutor().getTId() != null) {
            student1 = studentDao.selectStudent(student.getStudentId(), student.getTutor().getTId());

            if (student1 == null) {
                return new StudentExecution(StudentStateEnum.NOSTUDENT);
            }

            try {
                student1 = fillStudent(student, student1);
                if (studentDao.updateStudent(student1) > 0) {
                    return new StudentExecution(StudentStateEnum.MODIFIED);
                } else {
                    return new StudentExecution(StudentStateEnum.FAILMODIFIED);
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }

        } else {
            return new StudentExecution(StudentStateEnum.NULLSTUDENT);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StudentExecution addStudent(Student student) throws RuntimeException {
        if (student != null && student.getTutor() != null && student.getTutor().getTId() != null) {
            try {
                int res = studentDao.insertStudent(student);
                if (res > 0) {
                    return new StudentExecution(StudentStateEnum.ADDSUCCESS);
                } else {
                    return new StudentExecution(StudentStateEnum.ADDFAILED);
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        } else {
            return new StudentExecution(StudentStateEnum.NULLSTUDENT);
        }
    }

    @Override
    public List<Student> getAllStudents(Integer tId) {
        return studentDao.selectAllStudents(tId);
    }

    @Override
    public Student getStudent(Integer studentId, Integer tId) {
        return studentDao.selectStudent(studentId, tId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public StudentExecution deleteStudent(Integer sId, Integer tId) {

        try {
            int res = studentDao.deleteStudent(tId, sId);
            if (res > 0) {
                return new StudentExecution(StudentStateEnum.MODIFIED);
            } else {
                return new StudentExecution(StudentStateEnum.FAILMODIFIED);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<String> getGroupInfo() {
        return GroupStateEnum.getAllGroup();
    }

    //In case the student objet coming from the front are illegle, we will keep attributes non null their old value.
    private Student fillStudent(Student src, Student output) {
        //Those are attribute that can't be null
        if (src.getAddress() != null) {
            output.setAddress(src.getAddress());
        }
        if (src.getCharger() != null) {
            output.setCharger(src.getCharger());
        }
        if (src.getCompanyName() != null) {
            output.setCompanyName(src.getCompanyName());
        }
        if (src.getStartDate() != null) {
            output.setStartDate(src.getStartDate());
        }
        if (src.getEndDate() != null) {
            output.setEndDate(src.getEndDate());
        }
        if (src.getStudentGroup() != null) {
            output.setStudentGroup(src.getStudentGroup());
        }
        if (src.getFirstName() != null) {
            output.setFirstName(src.getFirstName());
        }
        if (src.getLastName() != null) {
            output.setLastName(src.getLastName());
        }
        //Those are attribute that can be null
        output.setNoteCom(src.getNoteCom());
        output.setNoteTech(src.getNoteTech());
        output.setComment(src.getComment());
        output.setDescription(src.getDescription());

        return output;
    }


    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
