package br.fai.reggistre.api.service;

import java.util.List;

import br.fai.reggistre.model.entities.Historico;


public interface HistoricService {
	
	List<Historico> readAll();
	
	Long create(Historico entity);
		
	Historico readById(Long id);
	
	boolean update(Historico entity);
	
	boolean deleteById(Long id);

}
