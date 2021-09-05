package br.fai.reggistre.model.entities;

public class TipoConta extends BasePojo{
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "TipoConta [nome=" + nome  +"]";
	}

}
