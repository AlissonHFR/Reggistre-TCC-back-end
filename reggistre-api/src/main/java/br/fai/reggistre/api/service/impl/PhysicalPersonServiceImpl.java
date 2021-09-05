package br.fai.reggistre.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fai.reggistre.api.service.PhysicalPersonService;
import br.fai.reggistre.db.dao.PhysicalPersonDao;
import br.fai.reggistre.model.entities.PessoaFisica;

@Service
public class PhysicalPersonServiceImpl implements PhysicalPersonService {
	
	@Autowired
	private PhysicalPersonDao physicalPersonDao;

	@Override
	public List<PessoaFisica> readAll() {
		
		return physicalPersonDao.readAll();
	}

	@Override
	public Long create(PessoaFisica entity) {
		
		return physicalPersonDao.create(entity);
	}

	@Override
	public PessoaFisica readById(Long id) {
		
		return physicalPersonDao.readById(id);
	}

	@Override
	public boolean update(PessoaFisica entity) {
		
		return physicalPersonDao.update(entity);
	}

	@Override
	public boolean deleteById(Long id) {
		
		return physicalPersonDao.deleteById(id);
	}

	@Override
	public PessoaFisica readByLogin(String nomeUsuario, String senha) {
		
		return physicalPersonDao.readByLogin(nomeUsuario, senha);
	}

}