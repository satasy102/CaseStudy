package com.CodeGym.DAO;

import com.CodeGym.entity.Class.Student;

public interface StudentManager {
    Student getStudent();
    void showAllStudent();
    void add();
    void edit();
    void delete();
    void inputScore();
    void rank();
}
