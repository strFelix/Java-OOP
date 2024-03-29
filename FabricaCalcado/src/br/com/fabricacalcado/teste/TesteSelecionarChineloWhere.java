package br.com.fabricacalcado.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;


public class TesteSelecionarChineloWhere {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		ChineloDAO chinelodao = new ChineloDAO(con);

		String nome = "Havaianas"; 
		
		ArrayList<Chinelo> lista = chinelodao.retornarDadosChinelo(nome);

		if (lista != null) {
			for (Chinelo chineloSearch : lista) {
				System.out.println("Tamanho do chinelo: " + chineloSearch.getTamanho());
				System.out.println("Peso do chinelo: " + chineloSearch.getPeso());
				System.out.println("Nome do chinelo: " + chineloSearch.getNome());
				System.out.println("Quantidade de tiras do chinelo " + chineloSearch.getQuantidadeTiras() +
				"\n"
						);;
				
			}
		}
		Conexao.fecharConexao(con);
	}
}
