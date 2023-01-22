 package com.spring.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class EmpController {
	
	
	private EmpInterface repository;
	public EmpController (EmpInterface repository) {
		this.repository=repository;
	}
	@GetMapping("/emp")
	List<Emp>get(){
		return repository.findAll();

	}
	
	@PostMapping("/emp")	
	Emp save(@RequestBody Emp newEmp){
		return repository.save(newEmp);
}
	@GetMapping("/emp/{id}")
	Optional<Emp> getid(@PathVariable Integer id) {
		return repository.findById(id);
	}
	@PutMapping("/emp/{id}")
	Optional<Object> update(@PathVariable Integer id, @RequestBody Emp newEmp) {
		return repository.findById(id).map(Emp->{
			Emp.setPhone(newEmp.getPhone());
			Emp.setPass(newEmp.getPass());
			Emp updatedemployee = repository.save(Emp);
			return updatedemployee;
		});
	}
	
	@DeleteMapping("/emp/{id}")
	void delete (@PathVariable Integer id) {
		repository.deleteById(id);
	}
}