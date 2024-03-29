package br.com.fabricacalcado.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fabricacalcado.conexao.Conexao;
import br.com.fabricacalcado.dao.ChineloDAO;
import br.com.fabricacalcado.model.Chinelo;


public class TesteSelecionarChinelo {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		ChineloDAO chinelodao = new ChineloDAO(con);

		ArrayList<Chinelo> lista = chinelodao.retornarDadosChinelo();

		if (lista != null) {
			for (Chinelo chinelo : lista) {
				System.out.println("Tamanho do chinelo: " + chinelo.getTamanho());
				System.out.println("Peso do chinelo: " + chinelo.getPeso());
				System.out.println("Nome do chinelo: " + chinelo.getNome());
				System.out.println("Quantidade de tiras do chinelo " + chinelo.getQuantidadeTiras() +
				"\n"
						);;
				
			}
		}
		Conexao.fecharConexao(con);
	}
}
