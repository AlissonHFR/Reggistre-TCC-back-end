package br.fai.reggistre.db.dao;

import java.util.List;

import br.fai.reggistre.model.entities.PremioPessoa;

public interface AwardPersonDao {
	
	List<PremioPessoa> readAll();
	
	Long create(PremioPessoa entity);
		
	PremioPessoa readById(Long id);
	
	boolean update(PremioPessoa entity);
	
	boolean deleteById(Long id);

}
