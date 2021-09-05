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
import br.fai.reggistre.db.dao.PhysicalPersonDao;
import br.fai.reggistre.model.entities.Categoria;
import br.fai.reggistre.model.entities.PessoaFisica;

@Repository
public class PhysicalPersonDaoImpl implements PhysicalPersonDao{

	@Override
	public List<PessoaFisica> readAll() {
		
		List<PessoaFisica> pessoasList = new ArrayList<PessoaFisica>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM pessoa_fisica ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				PessoaFisica pessoaFisica = new PessoaFisica();
				pessoaFisica.setId(resultSet.getLong("id"));
				pessoaFisica.setNomeCompleto(resultSet.getString("nome_completo"));
				pessoaFisica.setSituacao(resultSet.getBoolean("situacao"));
				pessoaFisica.setData(resultSet.getTimestamp("data"));
				pessoaFisica.setEmail(resultSet.getString("email"));
				pessoaFisica.setEmailAlternativo(resultSet.getString("email_alternativo"));
				pessoaFisica.setNomeUsuario(resultSet.getString("nome_usuario"));
				pessoaFisica.setSenha(resultSet.getString("senha"));
				pessoaFisica.setQuantidadePontos(resultSet.getInt("quantidade_pontos"));
				pessoaFisica.setIdTipoConta(resultSet.getLong("id_tipo_conta"));
				
				pessoasList.add(pessoaFisica);
			}
			
		} catch (Exception e) {
			System.out.println("CategoryDaoImpl pacote DB readAll");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		return pessoasList;
	}

	@Override
	public Long create(PessoaFisica entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Long id = Long.valueOf(0);
		
		String sql = "INSERT INTO pessoa_fisica (nome_completo, situacao, data, email, email_alternativo, nome_usuario, senha, quantidade_pontos, id_tipo_conta) ";
		sql += " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); " ; 
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement  = connection.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, entity.getNomeCompleto());
			preparedStatement.setBoolean(2, entity.isSituacao());
			preparedStatement.setTimestamp(3, entity.getData());
			preparedStatement.setString(4, entity.getEmail());
			preparedStatement.setString(5, entity.getEmailAlternativo());
			preparedStatement.setString(6, entity.getNomeUsuario());
			preparedStatement.setString(7, entity.getSenha());
			preparedStatement.setInt(8, entity.getQuantidadePontos());
			preparedStatement.setLong(9, entity.getIdTipoConta());
			
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
				System.out.println("PhysicalPersonDaoImpl pacote DB create");
				e1.printStackTrace();
			}
			return id;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}

	@Override
	public PessoaFisica readById(Long id) {
		
		PessoaFisica pessoaFisica = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM pessoa_fisica WHERE id = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong(1, id);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				pessoaFisica = new PessoaFisica();
				pessoaFisica.setId(resultSet.getLong("id"));
				pessoaFisica.setNomeCompleto(resultSet.getString("nome_completo"));
				pessoaFisica.setSituacao(resultSet.getBoolean("situacao"));
				pessoaFisica.setData(resultSet.getTimestamp("data"));
				pessoaFisica.setEmail(resultSet.getString("email"));
				pessoaFisica.setEmailAlternativo(resultSet.getString("email_alternativo"));
				pessoaFisica.setNomeUsuario(resultSet.getString("nome_usuario"));
				pessoaFisica.setSenha(resultSet.getString("senha"));
				pessoaFisica.setQuantidadePontos(resultSet.getInt("quantidade_pontos"));
				pessoaFisica.setIdTipoConta(resultSet.getLong("id_tipo_conta"));
				
			}
			
		} catch (Exception e) {
			System.out.println("PhysicalPersonDaoImpl pacote DB readById");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		
		return pessoaFisica;
	}

	@Override
	public boolean update(PessoaFisica entity) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String sql = "UPDATE pessoa_fisica SET nome_completo = ?, situacao = ?, data = ?, email = ?, email_alternativo = ?, nome_usuario = ?, senha = ?, quantidade_pontos = ?, id_tipo_conta = ?";
		sql += " WHERE id = ? ; ";
		
		try {
			connection = ConnectionFactory.getConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, entity.getNomeCompleto());
			preparedStatement.setBoolean(2, entity.isSituacao());
			preparedStatement.setTimestamp(3, entity.getData());
			preparedStatement.setString(4, entity.getEmail());
			preparedStatement.setString(5, entity.getEmailAlternativo());
			preparedStatement.setString(6, entity.getNomeUsuario());
			preparedStatement.setString(7, entity.getSenha());
			preparedStatement.setInt(8, entity.getQuantidadePontos());
			preparedStatement.setLong(9, entity.getIdTipoConta());
			preparedStatement.setLong(10, entity.getId());
			
			preparedStatement.execute();
			connection.commit();
			
			return true;
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("PhysicalPersonDaoImpl pacote DB update");
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
		
		String sql = "DELETE FROM pessoa_fisica  WHERE id = ? ; ";
		
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
				System.out.println("PhysicalPersonDaoImpl pacote DB delete");
				e1.printStackTrace();
			}
			return false;
		}finally {
			ConnectionFactory.close(preparedStatement, connection);
		}
	}
	
	@Override
	public PessoaFisica readByLogin(String nomeUsuario, String senha) {
		
		PessoaFisica pessoaFisica = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String sql = "SELECT * FROM pessoa_fisica WHERE nome_usuario = ? and senha = ? ;";
		
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, nomeUsuario);
			preparedStatement.setString(2, senha);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				pessoaFisica = new PessoaFisica();
				pessoaFisica.setId(resultSet.getLong("id"));
				pessoaFisica.setNomeCompleto(resultSet.getString("nome_completo"));
				pessoaFisica.setSituacao(resultSet.getBoolean("situacao"));
				pessoaFisica.setData(resultSet.getTimestamp("data"));
				pessoaFisica.setEmail(resultSet.getString("email"));
				pessoaFisica.setEmailAlternativo(resultSet.getString("email_alternativo"));
				pessoaFisica.setNomeUsuario(resultSet.getString("nome_usuario"));
				pessoaFisica.setSenha(resultSet.getString("senha"));
				pessoaFisica.setQuantidadePontos(resultSet.getInt("quantidade_pontos"));
				pessoaFisica.setIdTipoConta(resultSet.getLong("id_tipo_conta"));
				
			}
			
		} catch (Exception e) {
			System.out.println("PhysicalPersonDaoImpl pacote DB readByLogin");
		}finally {
			ConnectionFactory.close(resultSet, preparedStatement, connection);
		}
		
		
		return pessoaFisica;
		
	}

}
