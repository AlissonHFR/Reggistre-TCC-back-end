package br.fai.reggistre.model.entities;

import java.sql.Timestamp;

public class PremioPessoa extends BasePojo{
	
	private Long idPessoaFisica;
	private Long idPremio;
	private Timestamp dataFinalValidade;
	private Timestamp dataInicial;
	
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	public Long getIdPremio() {
		return idPremio;
	}
	public void setIdPremio(Long idPremio) {
		this.idPremio = idPremio;
	}
	public Timestamp getDataFinalValidade() {
		return dataFinalValidade;
	}
	public void setDataFinalValidade(Timestamp dataFinalValidade) {
		this.dataFinalValidade = dataFinalValidade;
	}
	public Timestamp getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Timestamp dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [idPessoaFisica=" + idPessoaFisica + ", idPremio=" + idPremio + ", dataFinalValidade="
				+ dataFinalValidade + ", dataInicial=" + dataInicial + "]";
	}

	
}


