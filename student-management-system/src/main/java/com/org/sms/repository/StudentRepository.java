package com.org.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.sms.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer> {

}
