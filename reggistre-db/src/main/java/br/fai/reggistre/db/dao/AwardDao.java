package br.fai.reggistre.db.dao;

import java.util.List;

import br.fai.reggistre.model.entities.Premio;

public interface AwardDao {
	
	List<Premio> readAll();
	
	Long create(Premio entity);
		
	Premio readById(Long id);
	
	boolean update(Premio entity);
	
	boolean deleteById(Long id);

}
