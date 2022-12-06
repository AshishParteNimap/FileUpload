package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.studentRepository;

@RestController
public class studentController {
@Autowired
private studentRepository repo;

@GetMapping("/getStudent")
public List<Student> getStudent(){
	return repo.findAll();
}

@GetMapping("/getStudentById/{id}")
public Student getById(@PathVariable int id) throws Exception {
	
	Optional<Student>student=repo.findById(id);
	if(student.isEmpty()) {
		
			throw new Exception("student missing with id: "+id);
		
	}
	return student.get();
}

@PostMapping("/addStudent")
public Student addStudent(@RequestBody Student student) {
	return repo.save(student);
}


@DeleteMapping("/deleteStudent/{id}")
public String deletStudent(@PathVariable int id,Student student) {
	 repo.deleteById(id);
	 return "student deleted of Id: "+student.getId();
}

@PutMapping("/updateStudent/{id}")
public ResponseEntity<Student>  updateById(@PathVariable int id,@RequestBody Student student) {
	Optional<Student> newStudent=repo.findById(id);
	Student student1=newStudent.get();
	student1.setId(student.getId());
	student1.setName(student.getName());
	
	student1.setStandard(student.getStandard());
	repo.save(student1);
	
	return ResponseEntity.ok(student1);
	
}

}
