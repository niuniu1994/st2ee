package com.efrei.st2ee.dao.impl;

import com.efrei.st2ee.dao.TutorDao;
import com.efrei.st2ee.entity.Tutor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;

/**
 * @program: ST2EE
 * @description:
 * @author: xin
 * @create: 2020-10-29 17:44
 **/
@Repository("tutorDao")
public class TutorDaoImpl implements TutorDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class,readOnly = true)
    public Tutor selectTutor(String username, String password) {
        session = sessionFactory.getCurrentSession();
        String queryString = "from Tutor where username=:username and password=:password";
        Query query = session.createQuery(queryString).setParameter("username", username).setParameter("password", password);
        Tutor tutor = (Tutor) query.getSingleResult();
        return tutor != null ? tutor : null;
    }
}
