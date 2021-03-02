package it.jac.studenti.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.jac.studenti.dao.CorsoRepository;
import it.jac.studenti.dao.StudenteRepository;
import it.jac.studenti.dto.Response;
import it.jac.studenti.entity.Corso;
import it.jac.studenti.entity.Studente;

public class CorsoService {
	
	@Autowired
	CorsoRepository corsoRepository;
	
	final static String error = "Nessun corso trovato.";
	
	//CREATE
	public Response<Corso> createCorso(Corso corso) {

		Response<Corso> response = new Response<Corso>();

		try {
			this.corsoRepository.save(corso); 

			response.setResult(corso);
			response.setResultTest(true);

		} catch (Exception e) {
			e.getStackTrace();
			response.setError("corso non creato");

		}

		return response;

	}
	
	
	//DELETE
			public Response<String> deleteCorsoById(int id) {

				Response<String> response = new Response<String>();

				try {
					this.corsoRepository.deleteById(id);

					response.setResult("corso eliminato.");
					response.setResultTest(true);

				} catch (Exception e) {
					response.setError("corso non eliminato correttamente.");
				}
				return response;
			}
			
			
	//UPDATE
			public Response<CorsoDTO> updateCorso(Corso corso) {

				Response<CorsoDTO> response = new Response<CorsoDTO>();

				try {

					this.corsoRepository.save(corso);

					response.setResult(CorsoDTO.build(corso));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;
			}
			
			
	
			
			//FIND STUDENT BY ID
			public Response<CorsoDTO> findCorsoById(int id) {

				Response<CorsoDTO> response = new Response<CorsoDTO>();

				try {

					Corso corso = this.corsoRepository.findById(id).get();

					response.setResult(CorsoDTO.build(corso));
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
			
			
			
			
			// FIND ALL
			public Response<List<CorsoDTO>> findAllCorsi() {

				Response<List<CorsoDTO>> response = new Response<List<CorsoDTO>>();

				List<CorsoDTO> result = new ArrayList<>();

				try {

					Iterator<Corso> iterator = this.corsoRepository.findAll().iterator();

					while (iterator.hasNext()) {

						Corso corso = iterator.next();
						result.add(CorsoDTO.build(corso));

					}

					response.setResult(result);
					response.setResultTest(true);

				} catch (Exception e) {

					response.setError(error);

				}

				return response;

			}
}
