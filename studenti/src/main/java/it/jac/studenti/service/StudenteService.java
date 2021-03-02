package it.jac.studenti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jac.studenti.dao.StudenteRepository;
import it.jac.studenti.dto.Response;
import it.jac.studenti.dto.StudenteDTO;
import it.jac.studenti.entity.Studente;

@Service
public class StudenteService {
	
	@Autowired
	StudenteRepository studenteRepository;
	
	final static String error = "Nessun customer trovato.";
	
	//CREATE
	public Response<Studente> createStudent(Studente studente) {

		Response<Studente> response = new Response<Studente>();

		try {
			this.studenteRepository.save(studente); 

			response.setResult(studente);
			response.setResultTest(true);

		} catch (Exception e) {
			e.getStackTrace();
			response.setError("studente non creato");

		}

		return response;

	}
	
	
	//DELETE
			public Response<String> deleteStudentById(int id) {

				Response<String> response = new Response<String>();

				try {
					this.studenteRepository.deleteById(id);

					response.setResult("studente eliminato.");
					response.setResultTest(true);

				} catch (Exception e) {
					response.setError("studente non eliminato correttamente.");
				}
				return response;
			}
			
			
	//UPDATE
			public Response<StudenteDTO> updateStudent(Studente studente) {

				Response<StudenteDTO> response = new Response<StudenteDTO>();

				try {

					this.studenteRepository.save(studente);

					response.setResult(StudenteDTO.build(studente));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;
			}
}
