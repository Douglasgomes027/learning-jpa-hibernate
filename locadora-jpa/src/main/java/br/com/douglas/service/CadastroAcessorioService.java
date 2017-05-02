package br.com.douglas.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.douglas.dao.AcessorioDAO;
import br.com.douglas.model.Acessorio;
import br.com.douglas.util.jpa.Transactional;


public class CadastroAcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		
		if (StringUtils.isBlank(acessorio.getDescricao())) {
			throw new NegocioException("A descrição do acessório é obrigatório");
		}
		
		this.acessorioDAO.salvar(acessorio);
	}

}
