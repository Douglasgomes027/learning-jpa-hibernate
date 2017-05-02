package br.com.douglas.model;

public enum Categoria {

	HATCH_COMPACTO("Hatch compacto"),
	HATCH_MEDIO("Hatch médio"),
	SEDAN_COMPACTO("Sedan compacto"),
	SEDAN_MEDIO("Sedan médio"),
	SEDAN_GRANDE("Sedan grande"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitário comercial");
	
	private String descricao;
	
	Categoria(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
}
