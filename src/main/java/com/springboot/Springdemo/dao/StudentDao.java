package com.springboot.Springdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.Springdemo.dto.StudentDto;
import com.springboot.Springdemo.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;
	public StudentDto saveStudentDto(StudentDto s) {
		return repository.save(s);
	}
	public List<StudentDto> displayAll()
	{
		return repository.findAll();
		
	}
	public StudentDto findStudentDtoById(int id) {
		Optional<StudentDto>optional=repository.findById(id);
			if(optional.isPresent()) {
				return optional.get();
		}
			return null;
	}
	
	public boolean deleteById(int id)
	{
		StudentDto s=findStudentDtoById(id);
		if(s!=null) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public StudentDto updateStudent(int id,StudentDto newStudentDto) {
		StudentDto existingStudentDto=findStudentDtoById(id);
		if(existingStudentDto!=null) {
		return repository.save(newStudentDto);
}
		return null;
}
}