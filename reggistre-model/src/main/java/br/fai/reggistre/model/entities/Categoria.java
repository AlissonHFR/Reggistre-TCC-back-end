package br.fai.reggistre.model.entities;

public class Categoria extends BasePojo{
	
	private String nome;
	private Long idPessoaFisica;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	
	
	@Override
	public String toString() {
		return "Categoria [nome=" + nome + ", idPessoaFisica=" + idPessoaFisica + "]";
	}

}
