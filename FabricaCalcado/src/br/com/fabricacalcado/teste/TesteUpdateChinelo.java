package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;

public class TesteUpdateChinelo {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		
		Chinelo chinelo = new Chinelo();
		ChineloDAO chineloDAO = new ChineloDAO(connection);
		
		chinelo.setTamanho(45);
		chinelo.setNome("Havaianas");
		
		System.out.println(chineloDAO.UpdateChinelo(chinelo));
		
		Conexao.fecharConexao(connection);

	}

}