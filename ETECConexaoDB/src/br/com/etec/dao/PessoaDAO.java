package br.com.etec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.etec.model.Pessoa;

public class PessoaDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public PessoaDAO(){
		
	}
	
	public PessoaDAO(Connection connection) {
		setConnection(connection);
	}	
	
	public String inserir(Pessoa pessoa) {
		String sql = "insert into Pessoa(nome, endereco) values (?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getEndereco());
			if(ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			}
			else {
				return "Erro ao inserir";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Deletar(Pessoa pessoa) {
		String sql = "delete from Pessoa where nome = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, pessoa.getNome());
			if(ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			}
			else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	
}
