package br.com.fabricaRoupa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricaRoupa.model.Blusa;

public class BlusaDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public BlusaDAO(){}
	
	public BlusaDAO(Connection connection){
		setConnection(connection);
	}	
	
	public String inserirBlusa(Blusa blusa) {
		String sql = "insert into blusa(peso, tipoTecido, touca) values (?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDouble(1, blusa.getPeso());
			ps.setString(2, blusa.getTipoTecido());
			ps.setBoolean(3, blusa.isTouca());
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
	
	public String DeletarBlusa(Blusa blusa) {
		String sql = "delete from blusa where tipoTecido like(?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, blusa.getTipoTecido());
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
	
	public String DeletarAllBlusas() {
		String sql = "delete from blusa ";
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
	
	public String UpdateBlusa(Blusa blusa) {
		String sql = "update blusa set peso = (?) where tipoTecido = (?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setDouble(1, blusa.getPeso());
			ps.setString(2, blusa.getTipoTecido());
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
	
	public ArrayList<Blusa> retornarDadosBlusa(){
		String sql = "select * from blusa";
		ArrayList<Blusa> retornarDadosBlusa = new ArrayList<Blusa>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Blusa blusa = new Blusa();
					blusa.setPeso(rs.getInt(1)); 
					blusa.setTipoTecido(rs.getString(2));
					blusa.setTouca(rs.getBoolean(3));
					
					retornarDadosBlusa.add(blusa);
				} return retornarDadosBlusa;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}
