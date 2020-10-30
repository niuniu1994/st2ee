package com.efrei.st2ee.service.impl;

import com.efrei.st2ee.dao.TutorDao;
import com.efrei.st2ee.entity.Tutor;
import com.efrei.st2ee.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-29 18:03
 **/
@Service("tutorService")
public class TutorServiceImpl implements TutorService {
    @Autowired
    TutorDao tutorDao;

    @Override
    public Tutor login(String username, String password) {
        return tutorDao.selectTutor(username, password);
    }
}
