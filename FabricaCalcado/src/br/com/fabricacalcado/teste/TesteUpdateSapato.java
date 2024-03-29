package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;

public class TesteUpdateSapato {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatoDAO = new SapatoDAO(connection);
		
		sapato.setTamanho(42);
		sapato.setNome("Havaianas");
		
		System.out.println(sapatoDAO.UpdateSapato(sapato));
		
		Conexao.fecharConexao(connection);

	}

}