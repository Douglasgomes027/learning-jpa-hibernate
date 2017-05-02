package br.com.douglas.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.douglas.dao.ModeloCarroDAO;
import br.com.douglas.model.ModeloCarro;
import br.com.douglas.util.jpa.Transactional;



public class CadastroModeloCarroService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ModeloCarroDAO modeloCarroDAO;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		validar(modeloCarro);
		
		this.modeloCarroDAO.salvar(modeloCarro);
	}

	private void validar(ModeloCarro modeloCarro) throws NegocioException {
		if (StringUtils.isBlank(modeloCarro.getDescricao())) {
			throw new NegocioException("O nome do modelo é obrigatório.");
		}
		
		if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O fabricante e obrigatório");
		}
	}

}
