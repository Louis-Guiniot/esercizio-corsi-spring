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
import lombok.Data;

@Data

public class ClasseDto {
	
	private int idclasse;
	
	
	private String nome;
	
	private int capienza;
	
	
	public static ClasseDto build(Classe classe) {

		ClasseDto result = new ClasseDto();
		BeanUtils.copyProperties(classe, result);

		return result;
	}

}
