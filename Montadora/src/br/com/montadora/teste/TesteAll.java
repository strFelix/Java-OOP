package br.com.montadora.teste;

import java.sql.Connection;

import javax.swing.JOptionPane;

import br.com.montadora.DAO.CarroDAO;
import br.com.montadora.conexao.Conexao;
import br.com.montadora.model.Carro;

public class TesteAll {

	public static void main(String[] args) {
		System.out.println("1 - Insert | 2 - Delete Where | 3 - Delete All");
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:"));
		
		switch (choice) 
		{
		case 1:
			Insert();
			break;
		case 2:
			DeleteWhere();
			break;
		case 3:
			DeleteAll();
			break;
		default:
			System.out.println("Valor invalido");
		}
		
	}
	
	public static void Insert() {
		Connection connection = Conexao.abrirConexao();
		
		Carro carro = new Carro();
		CarroDAO carroDAO = new CarroDAO(connection);
		
		carro.setModeloCarro(JOptionPane.showInputDialog("Insina o nome do carro: "));
		carro.setNomeMontadora(JOptionPane.showInputDialog("Insina a montadora do carro: "));
		
		JOptionPane.showMessageDialog(null, carroDAO.inserir(carro));
		
		Conexao.fecharConexao(connection);
	}
	
	public static void DeleteWhere() {
		Connection connection = Conexao.abrirConexao();
		
		Carro carro = new Carro();
		CarroDAO carroDAO = new CarroDAO(connection);
		
		carro.setModeloCarro(JOptionPane.showInputDialog("Insina o nome do carro que deseja deletar: "));
		
		JOptionPane.showMessageDialog(null, carroDAO.DeletarWithWhere(carro));
		
		Conexao.fecharConexao(connection);
	}
	
	public static void DeleteAll() {
		Connection connection = Conexao.abrirConexao();
		CarroDAO carroDAO = new CarroDAO(connection);

		JOptionPane.showMessageDialog(null, carroDAO.DeletarNoWhere());
		
		Conexao.fecharConexao(connection);
	}
}
