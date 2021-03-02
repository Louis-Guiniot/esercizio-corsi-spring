package it.jac.studenti.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.jac.studenti.dao.ClasseRepository;
import it.jac.studenti.dao.StudenteRepository;
import it.jac.studenti.dto.Response;
import it.jac.studenti.entity.Classe;
import it.jac.studenti.entity.Studente;

public class ClasseService {
	
	@Autowired
	ClasseRepository classeRepository;
	
	final static String error = "Nessuna classe trovata.";
	
	//CREATE
	public Response<Classe> createClasse(Classe classe) {

		Response<Classe> response = new Response<Classe>();

		try {
			this.classeRepository.save(classe); 

			response.setResult(classe);
			response.setResultTest(true);

		} catch (Exception e) {
			e.getStackTrace();
			response.setError("classe non creata");

		}

		return response;

	}
	
	
	//DELETE
			public Response<String> deleteClasseById(int id) {

				Response<String> response = new Response<String>();

				try {
					this.classeRepository.deleteById(id);

					response.setResult("classe eliminato.");
					response.setResultTest(true);

				} catch (Exception e) {
					response.setError("classe non eliminato correttamente.");
				}
				return response;
			}
			
			
	//UPDATE
			public Response<ClasseDTO> updateClasse(Classe classe) {

				Response<ClasseDTO> response = new Response<ClasseDTO>();

				try {

					this.classeRepository.save(classe);

					response.setResult(ClasseDTO.build(classe));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;
			}
			
			
	
			
			//FIND STUDENT BY ID
			public Response<ClasseDTO> findClasseById(int id) {

				Response<ClasseDTO> response = new Response<ClasseDTO>();

				try {

					Classe classe = this.classeRepository.findById(id).get();

					response.setResult(ClasseDTO.build(classe));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
			
			
			
			
			// FIND ALL
			public Response<List<ClasseDTO>> findAllClassi() {

				Response<List<ClasseDTO>> response = new Response<List<ClasseDTO>>();

				List<ClasseDTO> result = new ArrayList<>();

				try {

					Iterator<Classe> iterator = this.classeRepository.findAll().iterator();

					while (iterator.hasNext()) {

						Classe classe = iterator.next();
						result.add(ClasseDTO.build(classe));

					}

					response.setResult(result);
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
}
