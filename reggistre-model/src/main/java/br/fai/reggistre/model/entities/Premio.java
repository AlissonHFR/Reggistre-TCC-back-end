package br.fai.reggistre.model.entities;

public class Premio extends BasePojo{
	private String nome;
	private int quantidadePontos;
	private Long idTipoConta;
	private int numDias;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadePontos() {
		return quantidadePontos;
	}
	public void setQuantidadePontos(int quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}
	public Long getIdTipoConta() {
		return idTipoConta;
	}
	public void setIdTipoConta(Long idTipoConta) {
		this.idTipoConta = idTipoConta;
	}
	public int getNumDias() {
		return numDias;
	}
	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}
	
	
	
	@Override
	public String toString() {
		return "Premio [nome=" + nome + ", quantidadePontos=" + quantidadePontos + ", idTipoConta=" + idTipoConta
				+ ", numDias=" + numDias + "]";
	}
	
	
	

}
