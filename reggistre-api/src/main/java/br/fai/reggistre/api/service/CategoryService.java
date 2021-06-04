package br.fai.reggistre.api.service;

import java.util.List;

import br.fai.reggistre.model.entities.Categoria;

public interface CategoryService {
	List<Categoria> readAll();
	
	Long create(Categoria entity);
		
	Categoria readById(Long id);
	
	boolean update(Categoria entity);
	
	boolean deleteById(Long id);
}