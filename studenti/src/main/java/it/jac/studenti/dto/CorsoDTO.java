package it.jac.studenti.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import it.jac.studenti.entity.Classe;
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
