package it.jac.studenti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.jac.studenti.dto.Response;
import it.jac.studenti.entity.Classe;
import it.jac.studenti.service.ClasseService;

@RestController
@RequestMapping("/rest/classe")
public class ClasseRestController {
	
private static Logger log = LoggerFactory.getLogger(ClasseRestController.class);
	
	@Autowired
	ClasseService classeService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllClasss() {

		log.info("Ricevuta richiesta della lista degli classe");
		
		return classeService.findAllClassi();
		
	}
	
	
	
	@PostMapping(path="/create")
	public Response<?> createClass(@RequestBody Classe s){
		
		return classeService.createClasse(s);
	}
	
	@PostMapping(path="/delete")
	public Response<?> deleteClass(@RequestBody String id){
		int intId=Integer.parseInt(id);
		return classeService.deleteClasseById(intId);
	}
	
	@PostMapping(path="/update")
	public Response<?> updateClass(@RequestBody Classe s){
		return classeService.updateClasse(s);
	}
	
	
	
	@PostMapping(path="/findClassById")
	public Response<?> findClassById(String id){
		int intId=Integer.parseInt(id);
		return classeService.findClasseById(intId);
	}
	

}
