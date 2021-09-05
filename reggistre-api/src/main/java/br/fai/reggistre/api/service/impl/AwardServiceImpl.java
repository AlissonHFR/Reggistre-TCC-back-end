package br.fai.reggistre.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.reggistre.api.service.AwardService;
import br.fai.reggistre.db.dao.AwardDao;
import br.fai.reggistre.model.entities.Premio;

@Service
public class AwardServiceImpl implements AwardService{
	
	@Autowired
	private AwardDao awardDao;
	
	@Override
	public List<Premio> readAll() {
		
		return awardDao.readAll();
	}

	@Override
	public Long create(Premio entity) {
		
		return awardDao.create(entity);
	}

	@Override
	public Premio readById(Long id) {
		
		return awardDao.readById(id);
	}

	@Override
	public boolean update(Premio entity) {
		
		return awardDao.update(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		
		return awardDao.deleteById(id);
	}

}
