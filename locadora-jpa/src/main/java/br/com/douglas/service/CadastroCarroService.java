package br.com.douglas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.douglas.dao.CarroDAO;
import br.com.douglas.model.Carro;
import br.com.douglas.util.jpa.Transactional;



public class CadastroCarroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDAO;
	
	@Transactional
	public void salvar(Carro carro) throws NegocioException {
		
		if (carro.getPlaca() == null || carro.getPlaca().trim().equals("")) {
			throw new NegocioException("A placa é obrigatória");
		}
		
		this.carroDAO.salvar(carro);
	}

}
