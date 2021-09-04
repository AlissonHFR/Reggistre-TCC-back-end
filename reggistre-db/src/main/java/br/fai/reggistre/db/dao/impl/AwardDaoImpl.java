package br.fai.reggistre.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.fai.reggistre.db.connection.ConnectionFactory;
import br.fai.reggistre.db.dao.AwardDao;
import br.fai.reggistre.model.entities.Premio;

public class AwardDaoImpl implements AwardDao{

	@Override
	public List<Premio> readAll() {
		
		List<Premio> premioList = new ArrayList<Premio>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM premio ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Premio premio = new Premio();
				premio.setId(resultSet.getLong("id"));
				premio.setNome(resultSet.getString("nome"));
				premio.setQuantidadePontos(resultSet.getInt("quantidade_pontos"));
				premio.setIdTipoConta(resultSet.getLong("id_tipo_conta"));
				premio.setNumDias(resultSet.getInt("num_dias"));
				
				premioList.add(premio);
			}
			
		} catch (Exception e) {
			System.out.println("AwardDaoImpl pacote DB readAll");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return premioList;
	}

	@Override
	public Long create(Premio entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "INSERT INTO premio (nome, quantidade_pontos, num_dias, id_tipo_conta) ";
		sql+= " VALUES (?, ?, ?, ?); ";
		
		Long id = Long.valueOf(0);
		
		try {
			
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setInt(2, entity.getQuantidadePontos());
			preparedStatement.setInt(3, entity.getNumDias());
			preparedStatement.setLong(4, entity.getIdTipoConta());
			
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
				System.out.println("AwardDaoImpl pacote DB create");
				e1.printStackTrace();
			}
			return id;
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public Premio readById(Long id) {
		
		Premio premio = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM premio WHERE id = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				premio = new Premio();
				premio.setId(resultSet.getLong("id"));
				premio.setNome(resultSet.getString("nome"));
				premio.setQuantidadePontos(resultSet.getInt("quantidade_pontos"));
				premio.setNumDias(resultSet.getInt("num_dias"));
				premio.setIdTipoConta(resultSet.getLong("id_tipo_conta"));
				
			}
			
		} catch (Exception e) {
			System.out.println("AwardDaoImpl pacote db readById");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return premio;
	}

	@Override
	public boolean update(Premio entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE premio SET nome = ?, quantidade_pontos = ?, num_dias = ?, id_tipo_conta = ? ";
		sql += " WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getNome());
			preparedStatement.setInt(2, entity.getQuantidadePontos());
			preparedStatement.setInt(3, entity.getNumDias());
			preparedStatement.setLong(4, entity.getIdTipoConta());
			preparedStatement.setLong(5, entity.getId());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("AwardDaoImpl pacote DB update");
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
		
		String sql = " DELETE FROM premio WHERE id = ? ; ";
		
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
				System.out.println("AwardDaoImpl pacote DB deleteById");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

}
