package br.fai.reggistre.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.reggistre.api.service.HistoricService;
import br.fai.reggistre.db.dao.HistoricDao;
import br.fai.reggistre.model.entities.Historico;

@Service
public class HistoricServiceImpl implements HistoricService {
	
	@Autowired
	private HistoricDao historicDao;
	
	@Override
	public List<Historico> readAll() {
		
		return historicDao.readAll();
	}

	@Override
	public Long create(Historico entity) {
		
		return historicDao.create(entity);
	}

	@Override
	public Historico readById(Long id) {
		
		return historicDao.readById(id);
	}

	@Override
	public boolean update(Historico entity) {
		
		return historicDao.update(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		
		return historicDao.deleteById(id);
	}

}
