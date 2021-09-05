package br.fai.reggistre.model.entities;

import java.sql.Timestamp;

public class Historico extends BasePojo{
	
	private Timestamp data;
	private Long idPessoaFisica;
	
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	
	
	@Override
	public String toString() {
		return "Login [data=" + data + ", idUsuario=" + idPessoaFisica + "]";
	}
	
}
