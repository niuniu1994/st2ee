package com.efre.st2ee.dao;

import com.efrei.st2ee.dao.TutorDao;
import com.efrei.st2ee.entity.Tutor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-29 18:45
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TutorDaoTest {

    @Autowired
    TutorDao tutorDao;

    @Test
    public void testLogin(){
        String username = "luc";
        String password = "0000";
        Tutor tutor = tutorDao.selectTutor(username,password);
        Assert.assertNotNull(tutor);
    }
}
