package br.com.douglas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.douglas.dao.AcessorioDAO;
import br.com.douglas.model.Acessorio;
import br.com.douglas.service.NegocioException;
import br.com.douglas.util.jsf.FacesMessages;



@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AcessorioDAO acessorioDAO;
	
	private List<Acessorio> acessorios;
	
	private Acessorio acessorioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		acessorios = acessorioDAO.buscarTodos();
	}
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	public void excluir() {
		try {
			acessorioDAO.excluir(acessorioSelecionado);
			this.acessorios.remove(acessorioSelecionado);
			facesMessages.info("Acessório " + acessorioSelecionado.getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}
	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}
	
}
