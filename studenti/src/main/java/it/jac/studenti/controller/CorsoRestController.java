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
import it.jac.studenti.entity.Corso;
import it.jac.studenti.service.ClasseService;
import it.jac.studenti.service.CorsoService;


@RestController
@RequestMapping("/rest/corso")
public class CorsoRestController {
private static Logger log = LoggerFactory.getLogger(CorsoRestController.class);
	
	@Autowired
	CorsoService corsoService;
	
	@GetMapping(path = "/findAll")
	public Response<?> findAllClasss() {

		log.info("Ricevuta richiesta della lista dei corsi");
		
		return corsoService.findAllCorsi();
		
	}
	
	
	
	@PostMapping(path="/create")
	public Response<?> createCorso(@RequestBody Corso c){
		
		return corsoService.createCorso(c);
	}
	
	@PostMapping(path="/delete")
	public Response<?> deleteCorso(@RequestBody String id){
		int intId=Integer.parseInt(id);
		return corsoService.deleteCorsoById(intId);
	}
	
	@PostMapping(path="/update")
	public Response<?> updateClass(@RequestBody Corso c){
		return corsoService.updateCorso(c);
	}
	
	
	
	@PostMapping(path="/findClassById")
	public Response<?> findCorsoById(String id){
		int intId=Integer.parseInt(id);
		return corsoService.findCorsoById(intId);
	}
}
