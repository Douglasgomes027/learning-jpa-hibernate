package br.com.douglas.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.douglas.model.ApoliceSeguro;



public class ApoliceSeguroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(ApoliceSeguro apoliceSeguro) {
		manager.persist(apoliceSeguro);
	}

}
