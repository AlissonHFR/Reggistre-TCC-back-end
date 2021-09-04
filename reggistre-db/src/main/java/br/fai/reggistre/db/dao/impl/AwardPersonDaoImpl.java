package br.fai.reggistre.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.fai.reggistre.db.connection.ConnectionFactory;
import br.fai.reggistre.db.dao.AwardPersonDao;
import br.fai.reggistre.model.entities.Categoria;
import br.fai.reggistre.model.entities.PremioPessoa;

public class AwardPersonDaoImpl implements AwardPersonDao{

	@Override
	public List<PremioPessoa> readAll() {
		
		List<PremioPessoa> premioPessoaList = new ArrayList<PremioPessoa>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM premio_pessoa ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				PremioPessoa premioPessoa = new PremioPessoa();
				premioPessoa.setId(resultSet.getLong("id"));
				premioPessoa.setIdPessoaFisica(resultSet.getLong("id_pessoa_fisica"));
				premioPessoa.setDataFinalValidade(resultSet.getTimestamp("data_final_validade"));
				premioPessoa.setIdPremio(resultSet.getLong("id_premio"));
				premioPessoa.setDataInicial(resultSet.getTimestamp("data_inicial"));
				
				premioPessoaList.add(premioPessoa);
			}
			
		} catch (Exception e) {
			System.out.println("AwardPersonDaoImpl pacote DB readAll");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return premioPessoaList;
	}

	@Override
	public Long create(PremioPessoa entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = Long.valueOf(0);
		
		String sql = "INSERT INTO premio_pessoa (id_pessoa_fisica, data_final_validade, id_premio, data_inicial) ";
		sql += " VALUES (?, ?, ?, ?); " ; 
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement  = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setLong(1, entity.getIdPessoaFisica());
			preparedStatement.setTimestamp(2, entity.getDataFinalValidade());
			preparedStatement.setLong(3, entity.getIdPremio());
			preparedStatement.setTimestamp(4, entity.getDataInicial());
			
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()) {
				id =resultSet.getLong(1);
				
			}
			
			connection.commit();
			return id;
			
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("AwardPersonDaoImpl pacote DB create");
				e1.printStackTrace();
			}
			return id;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

	@Override
	public PremioPessoa readById(Long id) {
		PremioPessoa premioPessoa = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM premio_pessoa WHERE id = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				premioPessoa = new PremioPessoa();
				premioPessoa.setId(resultSet.getLong("id"));
				premioPessoa.setIdPessoaFisica(resultSet.getLong("id_pessoa_fisica"));
				premioPessoa.setDataFinalValidade(resultSet.getTimestamp("data_final_validade"));
				premioPessoa.setIdPremio(resultSet.getLong("id_premio"));
				premioPessoa.setDataInicial(resultSet.getTimestamp("data_inicial"));
				
			}
			
		} catch (Exception e) {
			System.out.println("AwardPersonDaoImpl pacote DB readById");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		
		return premioPessoa;
	}

	@Override
	public boolean update(PremioPessoa entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE premio_pessoa SET id_pessoa_fisica = ?, data_final_validade = ?, id_premio = ?, data_inicial = ?";
		sql += " WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, entity.getIdPessoaFisica());
			preparedStatement.setTimestamp(2, entity.getDataFinalValidade());
			preparedStatement.setLong(3, entity.getIdPremio());
			preparedStatement.setTimestamp(4, entity.getDataInicial());
			preparedStatement.setLong(5, entity.getId());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("AwardPersonDaoImpl pacote DB update");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

	@Override
	public boolean deleteById(Long id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "DELETE FROM premio_pessoa WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			preparedStatement.execute();
			connection.commit();
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("AwardPersonDaoImpl pacote DB delete");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

}
