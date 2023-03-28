package com.springboot.Springdemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Springdemo.dao.StudentDao;
import com.springboot.Springdemo.dto.StudentDto;
@RestController
public class Controller {

	@Autowired
	   StudentDao dao;
		@PostMapping("/student")
	   public StudentDto saveStudentDto(@RequestBody StudentDto s) 
		{
		   return dao.saveStudentDto(s);
		   
	   }
		@GetMapping("/students")
		
		public  List<StudentDto> displayAll()
		{
			return dao.displayAll();
		}
		@GetMapping("/byid")
		public StudentDto displayById(@RequestParam int id) {
			return dao.findStudentDtoById( id);
			
		}
		
		@DeleteMapping("/student")
		public String deleteById(@RequestParam int id) {
			
			boolean b=dao.deleteById(id);
			if(b) {
				return "table deleted sucessfully";
				
			}else {
				return "could not find the Student";
			}
		}
		@PutMapping("/student")
		public  StudentDto updateStudentDto(@RequestParam int id, @RequestParam StudentDto dto)
		{
			return dao.updateStudent(id, dto);
		}
		
}


