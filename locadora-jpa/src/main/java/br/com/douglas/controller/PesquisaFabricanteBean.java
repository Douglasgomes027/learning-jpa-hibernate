package br.com.douglas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.douglas.dao.FabricanteDAO;
import br.com.douglas.model.Fabricante;
import br.com.douglas.service.NegocioException;
import br.com.douglas.util.jsf.FacesMessages;



@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDAO fabricanteDAO;
	
	private List<Fabricante> fabricantes;
	
	private Fabricante fabricanteSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void excluir() {
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			facesMessages.info("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}
}
