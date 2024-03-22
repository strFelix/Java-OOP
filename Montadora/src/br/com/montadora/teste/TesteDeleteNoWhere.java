package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.DAO.CarroDAO;
import br.com.montadora.conexao.Conexao;

public class TesteDeleteNoWhere {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(connection);

		System.out.println(carroDAO.DeletarNoWhere());
		
		Conexao.fecharConexao(connection);
	}

}
