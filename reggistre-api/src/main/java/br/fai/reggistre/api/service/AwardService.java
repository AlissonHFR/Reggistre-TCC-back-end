package br.fai.reggistre.api.service;

import java.util.List;

import br.fai.reggistre.model.entities.Premio;


public interface AwardService {
	
	List<Premio> readAll();
	
	Long create(Premio entity);
		
	Premio readById(Long id);
	
	boolean update(Premio entity);
	
	boolean deleteById(Long id);

}
