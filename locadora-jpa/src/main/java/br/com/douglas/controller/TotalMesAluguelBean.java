package br.com.douglas.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.douglas.dao.AluguelDAO;
import br.com.douglas.model.Aluguel;



@Named
@ViewScoped
public class TotalMesAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private enum Meses {
		JANEIRO, FEVEREIRO, MARÇO, ABRIL, MAIO, JUNHO, JULHO, AGOSTO, SETEMBRO, OUTUBRO, NOVEMBRO, DEZEMBRO
	};

	private Meses mesSelecionado;

	private BigDecimal totalDoMes;

	private List<Aluguel> alugueis;

	@Inject
	private AluguelDAO aluguelDAO;

	public void buscarTotalAlugueisNoMes() {
		this.totalDoMes = this.aluguelDAO.calcularTotalDoMesDe(this.mesSelecionado.ordinal() + 1);
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public Meses getMesSelecionado() {
		return mesSelecionado;
	}

	public void setMesSelecionado(Meses mesSelecionado) {
		this.mesSelecionado = mesSelecionado;
	}

	public List<Meses> getMeses() {
		return Arrays.asList(Meses.values());
	}

	public BigDecimal getTotalDoMes() {
		return totalDoMes;
	}

}
