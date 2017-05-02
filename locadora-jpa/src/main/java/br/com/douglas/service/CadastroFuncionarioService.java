package br.com.douglas.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.douglas.dao.FuncionarioDAO;
import br.com.douglas.model.Funcionario;
import br.com.douglas.util.jpa.Transactional;



public class CadastroFuncionarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioDAO funcionarioDAO;
	
	@Transactional
	public void salvar(Funcionario funcionario) throws NegocioException {
		
		if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")) {
			throw new NegocioException("O nome do funcionário é obrigatório");
		}
		
		this.funcionarioDAO.salvar(funcionario);
	}

}
