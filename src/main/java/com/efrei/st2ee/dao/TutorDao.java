package com.efrei.st2ee.dao;

import com.efrei.st2ee.entity.Tutor;

public interface TutorDao {
    /**
     * find tutor by password and username
     *
     * @param username
     * @param password
     * @return {@link Tutor}
     */
    Tutor selectTutor(String username, String password);
}
