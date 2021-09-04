package br.fai.reggistre.db.dao;

import java.util.List;

import br.fai.reggistre.model.entities.Historico;


public interface HistoricDao {
	
	List<Historico> readAll();
	
	Long create(Historico entity);
		
	Historico readById(Long id);
	
	boolean update(Historico entity);
	
	boolean deleteById(Long id);

}
