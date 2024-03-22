package br.com.montadora.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.montadora.model.Carro;


public class CarroDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}

	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public CarroDAO(){
		
	}
	
	public CarroDAO(Connection connection) {
		setConnection(connection);
	}	
	
	public String inserir(Carro carro) {
		String sql = "insert into Carro(modeloCarro, montadora) values (?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, carro.getModeloCarro());
			ps.setString(2, carro.getNomeMontadora());
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
	
	public String DeletarWithWhere(Carro carro) {
		String sql = "delete from Carro where modeloCarro = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, carro.getModeloCarro());
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
	
	public String DeletarNoWhere() {
		String sql = "delete from Carro";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			if(ps.executeUpdate() > 0) {
				return "Deletado todos os dados com sucesso";
			}
			else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
