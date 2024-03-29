package br.com.fabricacalcado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fabricacalcado.model.Sapato;

public class SapatoDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public SapatoDAO(){
		
	}
	
	public SapatoDAO(Connection connection) {
		setConnection(connection);
	}	
	
	public String inserirSapato(Sapato sapato) {
		String sql = "insert into sapato(tamanho, peso, nome, tipoTecido) values (?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, sapato.getTamanho());
			ps.setDouble(2, sapato.getPeso());
			ps.setString(3, sapato.getNome());
			ps.setString(4, sapato.getTipoTecido());
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
	
	public String DeletarSapato(Sapato sapato) {
		String sql = "delete from sapato where nome like(?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, sapato.getNome());
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
	
	public String UpdateSapato(Sapato sapato) {
		String sql = "update sapato set tamanho = (?) where nome = (?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, sapato.getTamanho());
			ps.setString(2, sapato.getNome());
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
	
	public ArrayList<Sapato> retornarDadosSapato(){
		String sql = "select * from sapato";
		ArrayList<Sapato> retornarDadosSapato = new ArrayList<Sapato>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Sapato sapato = new Sapato();
					sapato.setTamanho(rs.getInt(1));
					sapato.setPeso(rs.getDouble(2));
					sapato.setNome(rs.getString(3));
					sapato.setTipoTecido(rs.getString(4));
					
					retornarDadosSapato.add(sapato);
				} return retornarDadosSapato;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}
