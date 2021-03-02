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
@Table(name = "corso")
@Data

public class Corso {
	
	@Id
	@Column(name = "idcorso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcorso;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "classe_idclasse")
	private Date classe_idclasse;

}
