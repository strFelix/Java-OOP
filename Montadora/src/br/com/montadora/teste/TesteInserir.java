package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.DAO.CarroDAO;
import br.com.montadora.conexao.Conexao;
import br.com.montadora.model.Carro;

public class TesteInserir {

	public static void main(String[] args) {
		
		Connection connection = Conexao.abrirConexao();
		
		Carro carro = new Carro();
		CarroDAO carroDAO = new CarroDAO(connection);
		
		carro.setModeloCarro("Goleta");
		carro.setNomeMontadora("VW");
		
		System.out.println(carroDAO.inserir(carro));
		
		Conexao.fecharConexao(connection);

	}

}
