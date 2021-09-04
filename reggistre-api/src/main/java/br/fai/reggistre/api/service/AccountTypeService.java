package br.fai.reggistre.api.service;

import java.util.List;

import br.fai.reggistre.model.entities.TipoConta;

public interface AccountTypeService {
	
	List<TipoConta> readAll();
	
	Long create(TipoConta entity);
		
	TipoConta readById(Long id);
	
	boolean update(TipoConta entity);
	
	boolean deleteById(Long id);

}
