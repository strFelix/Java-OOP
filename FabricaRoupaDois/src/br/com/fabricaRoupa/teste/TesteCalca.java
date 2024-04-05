package br.com.fabricaRoupa.teste;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fabricaRoupa.conexao.Conexao;
import br.com.fabricaRoupa.dao.CalcaDAO;
import br.com.fabricaRoupa.model.Calca;
public class TesteCalca {

	public static void main(String[] args) {
		int choice  = Integer.parseInt(JOptionPane.showInputDialog("1 - insert | 2 -  delete | 3 - update | 4 - select * | 5 - delete all"));
		switch (choice) {
		case 1: 
		{
			InsertCalca();
			break;
		}
		case 2: 
		{
			DeleteCalca();
			break;
		}
		case 3: 
		{
			UpdateCalca();
			break;
		}
		case 4: 
		{
			SelectCalca();
			break;
		}
		case 5: 
		{
			DeleteAll();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public static void InsertCalca() 
	{
		Connection connection = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcaDAO = new CalcaDAO(connection);
		
		calca.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso: ")));
		calca.setTipoTecido(JOptionPane.showInputDialog("Tipo tecido: "));
		calca.setTipo(JOptionPane.showInputDialog("Tipo da calca: "));
		
		System.out.println(calcaDAO.inserirCalca(calca));
		
		Conexao.fecharConexao(connection);
	}

	public static void DeleteCalca()
	{
		Connection connection = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcaDAO = new CalcaDAO(connection);
		
		calca.setTipo(JOptionPane.showInputDialog("Tipo da calca: "));
		
		System.out.println(calcaDAO.DeletarCalca(calca));
		
		Conexao.fecharConexao(connection);
	}

	public static void UpdateCalca()
	{
		Connection connection = Conexao.abrirConexao();
		
		Calca calca = new Calca();
		CalcaDAO calcaDAO = new CalcaDAO(connection);
		
		calca.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso: ")));
		calca.setTipoTecido(JOptionPane.showInputDialog("Tipo tecido: "));
		
		System.out.println(calcaDAO.DeletarCalca(calca));
		
		Conexao.fecharConexao(connection);
	}
	
	public static void SelectCalca()
	{
		Connection connection = Conexao.abrirConexao();
		CalcaDAO calcaDAO = new CalcaDAO(connection);

		ArrayList<Calca> lista = calcaDAO.retornarDadosCalca();

		if (lista != null) {
			for (Calca calca : lista) {
				System.out.println("Peso do calca: " + calca.getPeso());
				System.out.println("Tecido do calca: " + calca.getTipoTecido());
				System.out.println("Tipo da calca: " + calca.getTipo());
				System.out.println("\n");
				
			}
		}
		Conexao.fecharConexao(connection);
	}
	
	public static void DeleteAll() 
	{
		Connection connection = Conexao.abrirConexao();
		
		CalcaDAO calcaDAO = new CalcaDAO(connection);
		
		System.out.println(calcaDAO.DeletarAllCalcas());
		
		Conexao.fecharConexao(connection);
	}
}
