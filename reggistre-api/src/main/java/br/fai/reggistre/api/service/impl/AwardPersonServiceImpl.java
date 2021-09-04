package br.fai.reggistre.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.reggistre.api.service.AwardPersonService;
import br.fai.reggistre.db.dao.AwardPersonDao;
import br.fai.reggistre.model.entities.PremioPessoa;

@Service
public class AwardPersonServiceImpl implements AwardPersonService {
	
	@Autowired
	private AwardPersonDao awardPersonDao;
	
	@Override
	public List<PremioPessoa> readAll() {
		
		return awardPersonDao.readAll();
	}

	@Override
	public Long create(PremioPessoa entity) {
		
		return awardPersonDao.create(entity);
	}

	@Override
	public PremioPessoa readById(Long id) {
		
		return awardPersonDao.readById(id);
	}

	@Override
	public boolean update(PremioPessoa entity) {
		
		return awardPersonDao.update(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		
		return awardPersonDao.deleteById(id);
	}

}
