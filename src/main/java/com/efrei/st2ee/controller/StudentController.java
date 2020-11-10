package com.efrei.st2ee.controller;

import com.efrei.st2ee.dto.*;
import com.efrei.st2ee.enums.*;
import com.efrei.st2ee.entity.Student;
import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-25 18:56
 **/

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{keyWord}")
    public String search(@PathVariable String keyWord, Model model, HttpSession session){
        Tutor tutor = (Tutor) session.getAttribute("tutor");
        Assert.notNull(tutor, "Authority needed, please login");
        List<Student> studentList = studentService.getSearchResult(keyWord, tutor.getTId());
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @GetMapping("/students")
    public String getStudentList(Model model, HttpSession session) {
        Tutor tutor = (Tutor) session.getAttribute("tutor");
        Assert.notNull(tutor, "Authority needed, please login");
        List<Student> studentList = studentService.getAllStudents(tutor.getTId());
        model.addAttribute("studentList", studentList);
        return "list";
    }

    @PutMapping("/students")
    @ResponseBody
    public String editInternshipProperties(@RequestBody List<StudentInternshipExecution> list) throws JsonProcessingException {
        StudentExecution studentExecution = studentService.modifyStudentInternship(list);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("msg", "success");
        if (studentExecution.getState() == StudentStateEnum.MODIFIED.getState()) {
            return objectMapper.writeValueAsString(map);
        }
        return "{'msg':'failure'}";
    }

    @GetMapping("/student/{sId}/detail")
    public String getStudent(@PathVariable int sId, Model model, HttpSession session) {
        Tutor tutor = (Tutor) session.getAttribute("tutor");
        Assert.notNull(tutor, "Authority needed, please login");
        Student student = studentService.getStudent(sId, tutor.getTId());
        model.addAttribute("student", student);
        return "detail";
    }

    @GetMapping("/student")
    public String toAdd(Model model) {
        List<String> groups = studentService.getGroupInfo();
        model.addAttribute("student", new Student());
        model.addAttribute("groups", groups);
        model.addAttribute("msg", "normal");
        return "modification";
    }

    @PostMapping("/student")
    @ResponseBody
    public String addStudent(@RequestBody Student student,HttpSession session) {

        if (student != null) {
            Tutor tutor = (Tutor) session.getAttribute("tutor");
            Assert.notNull(tutor, "Authority needed, please login");
            student.setTutor(tutor);

            StudentExecution studentExecution = studentService.addStudent(student);
            if (studentExecution.getState() == StudentStateEnum.ADDSUCCESS.getState()){
                return "{\"msg\":\"success\"}";
            }else {
                return "{\"msg\":\"failed\"}";
            }
        }
        return "{\"msg\":\"failed\"}";

    }

    @PutMapping("/student")
    @ResponseBody
    public String editStudent(@RequestBody Student student,HttpSession session) {

        if (student != null) {
            Tutor tutor = (Tutor) session.getAttribute("tutor");
            student.setTutor(tutor);
            StudentExecution studentExecution = studentService.modifyStudent(student);
            if (studentExecution.getState() == StudentStateEnum.MODIFIED.getState()){
                return "{\"msg\":\"success\"}";
            }else {
                return "{\"msg\":\"failed\"}";
            }
        }
        return "{\"msg\":\"failed\"}";
    }


    @GetMapping("/student/{sId}")
    public String toEdit(@PathVariable int sId, HttpSession session, Model model) {

        Tutor tutor = (Tutor) session.getAttribute("tutor");
        Student student = studentService.getStudent(sId, tutor.getTId());
        List<String> groups = studentService.getGroupInfo();
        model.addAttribute("student", student);
        model.addAttribute("groups", groups);
        model.addAttribute("msg", "normal");
        return "modification";
    }



}
