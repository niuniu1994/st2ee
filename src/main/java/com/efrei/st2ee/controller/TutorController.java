package com.efrei.st2ee.controller;

import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-29 18:37
 **/
@Controller
public class TutorController {

    @Autowired
    TutorService tutorService;
    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Tutor tutor = tutorService.login(username, password);
        if (tutor == null){
            model.addAttribute("msg", "Username or password incorrect");
            return "redirect:login";
        }

        session.setAttribute("tutor", tutor);
        return "redirect:students";
    }
}
