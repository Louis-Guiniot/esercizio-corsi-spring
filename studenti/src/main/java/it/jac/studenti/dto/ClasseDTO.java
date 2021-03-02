package it.jac.studenti.dto;


import org.springframework.beans.BeanUtils;


import it.jac.studenti.entity.Classe;
import lombok.Data;

@Data

public class ClasseDTO {
	
	private int idclasse;
	
	
	private String nome;
	
	private int capienza;
	
	
	public static ClasseDTO build(Classe classe) {

		ClasseDTO result = new ClasseDTO();
		BeanUtils.copyProperties(classe, result);

		return result;
	}

}
