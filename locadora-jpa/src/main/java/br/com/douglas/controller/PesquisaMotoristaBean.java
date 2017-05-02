package br.com.douglas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.douglas.dao.MotoristaDAO;
import br.com.douglas.model.Motorista;
import br.com.douglas.service.NegocioException;
import br.com.douglas.util.jsf.FacesMessages;



@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	MotoristaDAO motoristaDAO;
	
	private List<Motorista> motoristas = new ArrayList<Motorista>();
	
	private Motorista motoristaSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		motoristas = motoristaDAO.buscarTodos();
	}
	
	public List<Motorista> getMotoristas() {
		return motoristas;
	}
	
	public void excluir() {
		try {
			motoristaDAO.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			facesMessages.info("Motorista " + motoristaSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}
	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}
	
}
