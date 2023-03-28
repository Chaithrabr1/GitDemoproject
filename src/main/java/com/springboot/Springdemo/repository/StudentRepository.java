package com.springboot.Springdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.Springdemo.dto.StudentDto;

public interface StudentRepository extends JpaRepository<StudentDto, Integer> {

	

}
