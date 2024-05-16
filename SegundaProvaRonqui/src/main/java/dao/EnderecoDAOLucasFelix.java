package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.EnderecoLucasFelix;


public class EnderecoDAOLucasFelix {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public EnderecoDAOLucasFelix(Connection con) {
		setCon(con);
	}

	public String inserir(EnderecoLucasFelix enderecoLucasFelix, int cnpjLucasFelix) {
		String sql = "insert into Endereco(cnpj, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cnpjLucasFelix);
			ps.setString(2, enderecoLucasFelix.getCep());
			ps.setString(3, enderecoLucasFelix.getLogradouro());
			ps.setString(4,  enderecoLucasFelix.getComplemento());
			ps.setString(5, enderecoLucasFelix.getBairro());
			ps.setString(6, enderecoLucasFelix.getLocalidade());
			ps.setString(7,  enderecoLucasFelix.getUf());
			ps.setString(8, enderecoLucasFelix.getIbge());
			ps.setString(9, enderecoLucasFelix.getGia());
			ps.setString(10,  enderecoLucasFelix.getDdd());
			ps.setString(11, enderecoLucasFelix.getSiafi());
			if (ps.executeUpdate() > 0) {
				return "Endereco inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}