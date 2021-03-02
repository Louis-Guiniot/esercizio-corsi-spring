package it.jac.studenti.dto;


import org.springframework.beans.BeanUtils;


import it.jac.studenti.entity.Corso;
import lombok.Data;

@Data

public class CorsoDTO {
	
	private int idcorso;
	
	
	private String titolo;
	
	private String descrizione;
	
	private int classe_idclasse;
	
	
	public static CorsoDTO build(Corso corso) {

		CorsoDTO result = new CorsoDTO();
		BeanUtils.copyProperties(corso, result);

		return result;
	}

}
