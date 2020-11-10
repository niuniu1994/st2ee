package com.efrei.st2ee.service;

import com.efrei.st2ee.entity.Tutor;

public interface TutorService {
    /**
     * tutor login function by examining username and password
     *
     * @param username
     * @param password
     * @return {@link Tutor}
     */

    Tutor login(String username, String password);
}
