package br.fai.reggistre.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.fai.reggistre.db.connection.ConnectionFactory;
import br.fai.reggistre.db.dao.AccountTypeDao;
import br.fai.reggistre.model.entities.TipoConta;

@Repository
public class AccountTypeDaoImpl implements AccountTypeDao{

	@Override
	public List<TipoConta> readAll() {
		
		List<TipoConta> tipoContaList = new ArrayList<TipoConta>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM tipo_conta ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				TipoConta tipoConta = new TipoConta();
				tipoConta.setId(resultSet.getLong("id"));
				tipoConta.setNome(resultSet.getString("nome"));
				
				tipoContaList.add(tipoConta);
			}
			
		} catch (Exception e) {
			System.out.println("CategoryDaoImpl pacote DB readAll");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return tipoContaList;
	}

	@Override
	public Long create(TipoConta entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = Long.valueOf(0);
		
		String sql = "INSERT INTO tipo_conta (nome) ";
		sql += " VALUES (?); " ; 
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement  = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, entity.getNome());
			
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
				System.out.println("AccountTypeDaoImpl pacote DB create");
				e1.printStackTrace();
			}
			return id;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

	@Override
	public TipoConta readById(Long id) {
		
		TipoConta tipoConta = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM tipo_conta WHERE id = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				tipoConta = new TipoConta();
				tipoConta.setId(resultSet.getLong("id"));
				tipoConta.setNome(resultSet.getString("nome"));
				
			}
			
		} catch (Exception e) {
			System.out.println("AccountTypeDaoImpl pacote DB readById");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		
		return tipoConta;
	}

	@Override
	public boolean update(TipoConta entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE tipo_conta SET nome = ?";
		sql += " WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setLong(2, entity.getId());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("AccountTypeDaoImpl pacote DB update");
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
		
		String sql = "DELETE FROM tipo_conta  WHERE id = ? ; ";
		
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
				System.out.println("AccountTypeDaoImpl pacote DB delete");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

}
