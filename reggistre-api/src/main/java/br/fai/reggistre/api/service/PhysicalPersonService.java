package br.fai.reggistre.api.service;

import java.util.List;


import br.fai.reggistre.model.entities.PessoaFisica;

public interface PhysicalPersonService {

	List<PessoaFisica> readAll();
	
	Long create(PessoaFisica entity);
		
	PessoaFisica readById(Long id);
	
	boolean update(PessoaFisica entity);
	
	boolean deleteById(Long id);
	
	PessoaFisica readByLogin(String nomeUsuario, String senha);

}
