package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteDeletarChinelo {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		
		Chinelo chinelo = new Chinelo();
		ChineloDAO chineloDAO = new ChineloDAO(connection);
		
		chinelo.setNome("Havaianas");
		
		System.out.println(chineloDAO.DeletarChinelo(chinelo));
		
		Conexao.fecharConexao(connection);

	}

}