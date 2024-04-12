package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;

public class EnderecoDAO {
	private Connection connection;

	public final Connection getConnection() {
		return connection;
	}
	public final void setConnection(Connection connection) {
		this.connection = connection;
	}
	public EnderecoDAO() {}
	
	public EnderecoDAO(Connection connection){
		setConnection(connection);
	}
	
	public String inserirEndereco(Endereco endereco) {
		String sql = "insert into endereco(cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, endereco.getCep());
			ps.setString(2, endereco.getLogradouro());
			ps.setString(3, endereco.getComplemento());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getLocalidade());
			ps.setString(6, endereco.getUf());
			ps.setString(7, endereco.getIbge());
			ps.setString(8, endereco.getGia());
			ps.setString(9, endereco.getDdd());
			ps.setString(10, endereco.getSiafi());
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
	
	public ArrayList<Endereco> retornarEnderecos(){
		String sql = "select * from endereco";
		ArrayList<Endereco> retornarDadosEndereco = new ArrayList<Endereco>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Endereco endereco = new Endereco();
					endereco.setCep(rs.getString(1)); 
					endereco.setLogradouro(rs.getString(2));
					endereco.setComplemento(rs.getString(3));
					endereco.setBairro(rs.getString(4));
					endereco.setLocalidade(rs.getString(5));
					endereco.setUf(rs.getString(6));
					endereco.setIbge(rs.getString(7));
					endereco.setGia(rs.getString(8));
					endereco.setDdd(rs.getString(9));
					endereco.setSiafi(rs.getString(10));
					
					retornarDadosEndereco.add(endereco);
				} return retornarDadosEndereco;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
}
