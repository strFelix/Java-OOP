//lucas felix
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

	public String inserir(EnderecoLucasFelix endereco) {
		String sql = "insert into endereco(cpfPessoa, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, endereco.getCpfPessoa());
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
				return "Endereco inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}