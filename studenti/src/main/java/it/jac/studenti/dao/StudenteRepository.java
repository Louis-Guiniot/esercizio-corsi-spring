package it.jac.studenti.dao;

import org.springframework.data.repository.CrudRepository;

import it.jac.studenti.entity.Studente;

public interface StudenteRepository extends CrudRepository<Studente, Integer>{

}
