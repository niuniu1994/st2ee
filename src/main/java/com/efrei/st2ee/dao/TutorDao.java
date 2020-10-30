package com.efrei.st2ee.dao;

import com.efrei.st2ee.entity.Tutor;

public interface TutorDao {
    Tutor selectTutor(String username, String password);
}
