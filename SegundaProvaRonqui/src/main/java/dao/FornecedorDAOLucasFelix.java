package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.FornecedorLucasFelix;


public class FornecedorDAOLucasFelix {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public FornecedorDAOLucasFelix(Connection con) {
		setCon(con);
	}

	public String inserir(FornecedorLucasFelix fornecedorLucasFelix) {
		String sql = "insert into Fornecedor(cnpj, nome) values (?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, fornecedorLucasFelix.getCnpjLucasFelix());
			ps.setString(2, fornecedorLucasFelix.getNomeLucasFelix());
			if (ps.executeUpdate() > 0) {
				return "Fornecedor inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}