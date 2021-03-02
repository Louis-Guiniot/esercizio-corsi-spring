package it.jac.studenti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/rest/studenti")
public class StudentiRestController {
	
	private static Logger log = LoggerFactory.getLogger(StudentiRestController.class);
	
	@Autowired
	StudenteService studentiService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllStudents() {

		log.info("Ricevuta richiesta della lista degli studenti");
		
		return studentiService.findAllStudents();
		
	}
	
	
	
	@PostMapping(path="/create")
	public Response<?> createStudent(@RequestBody Studente s){
		
		return studentiService.createStudent(s);
	}
	
	@PostMapping(path="/delete")
	public Response<?> deleteStudent(@RequestBody String id){
		int intId=Integer.parseInt(id);
		return studentiService.deleteStudentById(intId);
	}
	
	@PostMapping(path="/update")
	public Response<?> updateStudent(@RequestBody Studente s){
		return studentiService.updateStudent(s);
	}
	
	@PostMapping(path="/findAll")
	public Response<?> findAllStudents(){
		return studentiService.findAll();
	}
	
	@PostMapping(path="/findStudentById")
	public Response<?> findStudentById(String id){
		int intId=Integer.parseInt(id);
		return studentiService.findStudentById(intId);
	}

}
