package br.fai.reggistre.db.dao;

import java.util.List;

import br.fai.reggistre.model.entities.TipoConta;

public interface AccountTypeDao {
	
	List<TipoConta> readAll();
	
	Long create(TipoConta entity);
		
	TipoConta readById(Long id);
	
	boolean update(TipoConta entity);
	
	boolean deleteById(Long id);

}
