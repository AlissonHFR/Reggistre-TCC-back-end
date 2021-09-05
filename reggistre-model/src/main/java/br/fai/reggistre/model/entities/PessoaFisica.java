package br.fai.reggistre.model.entities;

import java.sql.Timestamp;

public class PessoaFisica extends BasePojo{
	
	
	private String nomeCompleto;
	private boolean situacao;
	private Timestamp data;
	private String email;
	private String emailAlternativo;
	private String nomeUsuario;
	private String senha;
	private int quantidadePontos;
	private Long idTipoConta;
	
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailAlternativo() {
		return emailAlternativo;
	}
	public void setEmailAlternativo(String emailAlternativo) {
		this.emailAlternativo = emailAlternativo;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	
	
	@Override
	public String toString() {
		return "PessoaFisica [nomeCompleto=" + nomeCompleto + ", situacao=" + situacao + ", data=" + data + ", email="
				+ email + ", emailAlternativo=" + emailAlternativo + ", nomeUsuario=" + nomeUsuario + ", senha=" + senha
				+ ", quantidadePontos=" + quantidadePontos + ", idTipoConta=" + idTipoConta + "]";
	}
	
}
