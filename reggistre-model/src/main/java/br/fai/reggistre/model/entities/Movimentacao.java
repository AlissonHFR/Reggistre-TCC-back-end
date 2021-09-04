package br.fai.reggistre.model.entities;

import java.sql.Timestamp;

public class Movimentacao extends BasePojo {
	
	private String nome;
	private String descricao;
	private Timestamp data;
	private String tipoMovimentacao;
	private float valor;
	private Long idCategoria;
	private Long idPessoaFisica;
	private Categoria categoria;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	@Override
	public String toString() {
		return "Movimentacao [nome=" + nome + ", descricao=" + descricao + ", data=" + data + ", tipoMovimentacao="
				+ tipoMovimentacao + ", valor=" + valor + ", idCategoria=" + idCategoria + ", idPessoaFisica="
				+ idPessoaFisica + "]";
	}
	
}
