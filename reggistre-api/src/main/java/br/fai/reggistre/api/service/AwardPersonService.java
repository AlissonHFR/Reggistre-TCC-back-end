package br.fai.reggistre.api.service;

import java.util.List;

import br.fai.reggistre.model.entities.PremioPessoa;

public interface AwardPersonService {
	
	List<PremioPessoa> readAll();
	
	Long create(PremioPessoa entity);
		
	PremioPessoa readById(Long id);
	
	boolean update(PremioPessoa entity);
	
	boolean deleteById(Long id);

}
