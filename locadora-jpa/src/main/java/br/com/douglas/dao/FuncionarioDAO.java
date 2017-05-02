package br.com.douglas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.douglas.model.Funcionario;
import br.com.douglas.service.NegocioException;
import br.com.douglas.util.jpa.Transactional;



public class FuncionarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Funcionario buscarPeloCodigo(Long codigo) {
		return manager.find(Funcionario.class, codigo);
	}
	
	public void salvar(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	public List<Funcionario> buscarTodos() {
		return manager.createQuery("from Funcionario", Funcionario.class).getResultList();
	}
	
	@Transactional
	public void excluir(Funcionario funcionario) throws NegocioException {
		funcionario = buscarPeloCodigo(funcionario.getCodigo());
		
		try {
			manager.remove(funcionario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Funcionario não pode ser excluído.");
		}
	}
}
