package br.com.fabricacalcado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricacalcado.model.Chinelo;

public class ChineloDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public ChineloDAO(){
		
	}
	
	public ChineloDAO(Connection connection) {
		setConnection(connection);
	}	
	
	public String inserirChinelo(Chinelo chinelo) {
		String sql = "insert into chinelo(tamanho, peso, nome, quantidadeTiras) values (?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, chinelo.getTamanho());
			ps.setDouble(2, chinelo.getPeso());
			ps.setString(3, chinelo.getNome());
			ps.setInt(4, chinelo.getQuantidadeTiras());
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
	
	public String DeletarChinelo(Chinelo chinelo) {
		String sql = "delete from chinelo where nome like(?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, chinelo.getNome());
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
	
	public String UpdateChinelo(Chinelo chinelo) {
		String sql = "update chinelo set tamanho = (?) where nome = (?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, chinelo.getTamanho());
			ps.setString(2, chinelo.getNome());
			if(ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			}
			else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Chinelo> retornarDadosChinelo(){
		String sql = "select * from chinelo";
		ArrayList<Chinelo> retornarDadosChinelo = new ArrayList<Chinelo>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Chinelo chinelo = new Chinelo();
					chinelo.setTamanho(rs.getInt(1));
					chinelo.setPeso(rs.getDouble(2));
					chinelo.setNome(rs.getString(3));
					chinelo.setQuantidadeTiras(rs.getInt(4));
					
					retornarDadosChinelo.add(chinelo);
				} return retornarDadosChinelo;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Chinelo> retornarDadosChinelo(String nome){
		String sql = "select * from chinelo where nome = (?)";
		ArrayList<Chinelo> retornarDadosChinelo = new ArrayList<Chinelo>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Chinelo chineloSearch = new Chinelo();
					chineloSearch.setTamanho(rs.getInt(1));
					chineloSearch.setPeso(rs.getDouble(2));
					chineloSearch.setNome(rs.getString(3));
					chineloSearch.setQuantidadeTiras(rs.getInt(4));
					
					retornarDadosChinelo.add(chineloSearch);
				} return retornarDadosChinelo;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}
