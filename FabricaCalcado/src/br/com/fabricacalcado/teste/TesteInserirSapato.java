package br.com.fabricacalcado.teste;

import java.sql.Connection;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.SapatoDAO;
import br.com.fabricacalcado.model.Sapato;

public class TesteInserirSapato {

	public static void main(String[] args) {
		Connection connection = Conexao.abrirConexao();
		
		Sapato sapato = new Sapato();
		SapatoDAO sapatoDAO = new SapatoDAO(connection);
		
		sapato.setTamanho(42);
		sapato.setPeso(200);
		sapato.setNome("Havaianas");
		sapato.setTipoTecido("Crocodilo");
		
		System.out.println(sapatoDAO.inserirSapato(sapato));
		
		Conexao.fecharConexao(connection);

	}

}