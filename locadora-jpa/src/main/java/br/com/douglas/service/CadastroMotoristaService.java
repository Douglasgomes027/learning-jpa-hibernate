package br.com.douglas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.douglas.dao.MotoristaDAO;
import br.com.douglas.model.Motorista;
import br.com.douglas.util.jpa.Transactional;



public class CadastroMotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaDAO motoristaDAO;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		this.motoristaDAO.salvar(motorista);
	}

}
