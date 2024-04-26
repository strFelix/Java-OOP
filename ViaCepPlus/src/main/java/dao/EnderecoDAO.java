package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Endereco;


public class EnderecoDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAO(Connection con) {
		setCon(con);
	}

	public String inserir(Endereco endereco) {
		String sql = "insert into endereco(cpf, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, endereco.getCpf());
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getLogradouro());
			ps.setString(4,  endereco.getComplemento());
			ps.setString(5, endereco.getBairro());
			ps.setString(6, endereco.getLocalidade());
			ps.setString(7,  endereco.getUf());
			ps.setString(8, endereco.getIbge());
			ps.setString(9, endereco.getGia());
			ps.setString(10,  endereco.getDdd());
			ps.setString(11, endereco.getSiafi());
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	//cpf, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi
	public ArrayList<Endereco> retornarDadosEndereco(){
		String sql = "select * from endereco";
		ArrayList<Endereco> retornarDadosEndereco = new ArrayList<Endereco>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					Endereco endereco = new Endereco();
					endereco.setCpf(rs.getInt(1));
					endereco.setCep(rs.getString(2));
					endereco.setLogradouro(rs.getString(3));
					endereco.setComplemento(rs.getString(4));
					endereco.setBairro(rs.getString(5));
					endereco.setLocalidade(rs.getString(6));
					endereco.setUf(rs.getString(7));
					endereco.setIbge(rs.getString(8));
					endereco.setGia(rs.getString(9));
					endereco.setDdd(rs.getString(10));
					endereco.setSiafi(rs.getString(11));
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