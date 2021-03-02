package it.jac.studenti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "classe")
@Data

public class Classe {
	
	@Id
	@Column(name = "idclasse")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idclasse;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "capienza")
	private int capienza;

}
