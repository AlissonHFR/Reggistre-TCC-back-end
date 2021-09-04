package br.fai.reggistre.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.reggistre.api.service.AccountTypeService;
import br.fai.reggistre.db.dao.AccountTypeDao;
import br.fai.reggistre.model.entities.TipoConta;

@Service
public class AccountTypeServiceImpl implements AccountTypeService {
	
	@Autowired
	private AccountTypeDao accountTypeDao;
	 
	@Override
	public List<TipoConta> readAll() {
		
		return accountTypeDao.readAll();
	}

	@Override
	public Long create(TipoConta entity) {
		
		return accountTypeDao.create(entity);
	}

	@Override
	public TipoConta readById(Long id) {
		
		return accountTypeDao.readById(id);
	}

	@Override
	public boolean update(TipoConta entity) {
		
		return accountTypeDao.update(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		
		return accountTypeDao.deleteById(id);
	}

}
