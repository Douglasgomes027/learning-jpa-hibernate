package br.com.douglas.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.douglas.model.Motorista;
import br.com.douglas.service.NegocioException;
import br.com.douglas.util.jpa.Transactional;



public class MotoristaDAO  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Motorista buscarPeloCodigo(Long codigo) {
		return manager.find(Motorista.class, codigo);
	}
	
	public void salvar(Motorista motorista) {
		manager.merge(motorista);
	}

	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos() {
		return manager.createQuery("from Motorista").getResultList();
	}
	
	@Transactional
	public void excluir(Motorista motorista) throws NegocioException {
		motorista = buscarPeloCodigo(motorista.getCodigo());
		try {
			manager.remove(motorista);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Motorista não pode ser excluído.");
		}
	}
}
