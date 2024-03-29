package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteInserirChinelo {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		
		Chinelo chinelo = new Chinelo();
		ChineloDAO chineloDAO = new ChineloDAO(connection);
		
		chinelo.setNome("Raider");
		chinelo.setPeso(200);
		chinelo.setTamanho(42);
		chinelo.setQuantidadeTiras(2);
		
		System.out.println(chineloDAO.inserirChinelo(chinelo));
		
		Conexao.fecharConexao(connection);
	}

}