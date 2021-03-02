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
import it.jac.studenti.entity.Studente;
import lombok.Data;

@Data

public class StudenteDto {
	
	
	private int idstudente;
	
	
	private String nome;
	
	private String cognome;
	
	private Date datanascita;
	
	private String sesso;
	
	public static StudenteDto build(Studente studente) {

		StudenteDto result = new StudenteDto();
		BeanUtils.copyProperties(studente, result);

		return result;
	}

}
