package br.com.fabricaRoupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricaRoupa.model.Calca;

public class CalcaDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public CalcaDAO(){}
	
	public CalcaDAO(Connection connection){
		setConnection(connection);
	}	
	
	public String inserirCalca(Calca calca) {
		String sql = "insert into calca(peso, tipoTecido, tipo) values (?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDouble(1, calca.getPeso());
			ps.setString(2, calca.getTipoTecido());
			ps.setString(3, calca.getTipo());
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
	
	public String DeletarCalca(Calca calca) {
		String sql = "delete from calca where tipo like(?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, calca.getTipo());
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
	
	public String DeletarAllCalcas() {
		String sql = "delete from calca ";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
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
	
	public String UpdateCalca(Calca calca) {
		String sql = "update calca set peso = (?) where tipo = (?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDouble(1, calca.getPeso());
			ps.setString(2, calca.getTipo());
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
	
	public ArrayList<Calca> retornarDadosCalca(){
		String sql = "select * from calca";
		ArrayList<Calca> retornarDadosCalca = new ArrayList<Calca>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Calca calca = new Calca();
					calca.setPeso(rs.getInt(1)); 
					calca.setTipoTecido(rs.getString(2));
					calca.setTipo(rs.getString(3));
					
					retornarDadosCalca.add(calca);
				} return retornarDadosCalca;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}
