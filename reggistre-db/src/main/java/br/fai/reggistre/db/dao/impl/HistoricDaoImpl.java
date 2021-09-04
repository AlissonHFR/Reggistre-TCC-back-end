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
import br.fai.reggistre.db.dao.HistoricDao;
import br.fai.reggistre.model.entities.Historico;

@Repository
public class HistoricDaoImpl implements HistoricDao{

	@Override
	public List<Historico> readAll() {
		
		List<Historico> historicList = new ArrayList<Historico>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM historico ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Historico historico = new Historico();
				historico.setId(resultSet.getLong("id"));
				historico.setIdPessoaFisica(resultSet.getLong("id_pessoa_fisica"));
				historico.setData(resultSet.getTimestamp("data"));
				
				historicList.add(historico);
			}
			
		} catch (Exception e) {
			System.out.println("HistoricDaoImpl pacote DB readAll");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return historicList;
	}

	@Override
	public Long create(Historico entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "INSERT INTO historico (data, id_pessoa_fisica) ";
		sql+= " VALUES (?, ?); ";
		
		Long id = Long.valueOf(0);
		
		try {
			
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			preparedStatement.setTimestamp(1, entity.getData());
			preparedStatement.setLong(2, entity.getIdPessoaFisica());
			
			
			preparedStatement.execute();
			resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			
			connection.commit();
			return id;
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
				System.out.println("LoginDaoImpl pacote DB create");
				e1.printStackTrace();
			}
			return id;
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public Historico readById(Long id) {
		
		Historico historico = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM historico WHERE id = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				historico = new Historico();
				historico.setId(resultSet.getLong("id"));
				historico.setData(resultSet.getTimestamp("data"));
				historico.setIdPessoaFisica(resultSet.getLong("id_pessoa_fisica"));
				
				
			}
			
		} catch (Exception e) {
			System.out.println("HistoricDaoImpl pacote db readById");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return historico;
	}

	@Override
	public boolean update(Historico entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE historico SET data = ?, id_pessoa_fisica = ? ";
		sql += " WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setTimestamp(1, entity.getData());
			preparedStatement.setLong(2, entity.getIdPessoaFisica());
			preparedStatement.setLong(3, entity.getId());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("HistoricDaoImpl pacote DB update");
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
		
		String sql = " DELETE FROM hiscorico WHERE id = ? ; ";
		
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
				System.out.println("HistoricDaoImpl pacote DB deleteById");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

}
