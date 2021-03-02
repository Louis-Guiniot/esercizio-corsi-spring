package it.jac.studenti.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.jac.studenti.dao.StudenteRepository;
import it.jac.studenti.dto.Response;
import it.jac.studenti.entity.Studente;

@Service
public class StudenteService {
	
	@Autowired
	StudenteRepository studenteRepository;
	
	final static String error = "Nessun studente trovato.";
	
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
			
			
	
			
			//FIND STUDENT BY ID
			public Response<StudenteDTO> findStudentById(int id) {

				Response<StudenteDTO> response = new Response<StudenteDTO>();

				try {

					Studente studente = this.studenteRepository.findById(id).get();

					response.setResult(StudenteDTO.build(studente));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
			
			
			
			
			// FIND ALL
			public Response<List<StudenteDTO>> findAllStudents() {

				Response<List<StudenteDTO>> response = new Response<List<StudenteDTO>>();

				List<StudenteDTO> result = new ArrayList<>();

				try {

					Iterator<Studente> iterator = this.studenteRepository.findAll().iterator();

					while (iterator.hasNext()) {

						Studente studente = iterator.next();
						result.add(StudenteDTO.build(studente));

					}

					response.setResult(result);
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
}
