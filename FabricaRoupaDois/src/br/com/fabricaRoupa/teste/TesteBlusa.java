package br.com.fabricaRoupa.teste;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fabricaRoupa.conexao.Conexao;
import br.com.fabricaRoupa.dao.BlusaDAO;
import br.com.fabricaRoupa.model.Blusa;
public class TesteBlusa {

	public static void main(String[] args) {
		int choice  = Integer.parseInt(JOptionPane.showInputDialog("1 - insert | 2 -  delete | 3 - update | 4 - select * | 5 - delete all"));
		switch (choice) {
		case 1: 
		{
			InsertBlusa();
			break;
		}
		case 2: 
		{
			DeleteBlusa();
			break;
		}
		case 3: 
		{
			UpdateBlusa();
			break;
		}
		case 4: 
		{
			SelectBlusa();
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
	
	public static void InsertBlusa() 
	{
		Connection connection = Conexao.abrirConexao();
		
		Blusa blusa = new Blusa();
		BlusaDAO blusaDAO = new BlusaDAO(connection);
		
		blusa.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso: ")));
		blusa.setTipoTecido(JOptionPane.showInputDialog("Tipo tecido: "));
		
		int touca = JOptionPane.showConfirmDialog(null, "Possui touca?", "Selecione:", JOptionPane.YES_NO_OPTION);
		
		System.out.println(touca);
		
		if(touca == 0) 
			blusa.setTouca(true);
		else
			blusa.setTouca(false); 		
		
		System.out.println(blusaDAO.inserirBlusa(blusa));
		
		Conexao.fecharConexao(connection);
	}

	public static void DeleteBlusa()
	{
		Connection connection = Conexao.abrirConexao();
		
		Blusa blusa = new Blusa();
		BlusaDAO blusaDAO = new BlusaDAO(connection);
		
		blusa.setTipoTecido(JOptionPane.showInputDialog("Tipo tecido: "));
		
		System.out.println(blusaDAO.DeletarBlusa(blusa));
		
		Conexao.fecharConexao(connection);
	}

	public static void UpdateBlusa()
	{
		Connection connection = Conexao.abrirConexao();
		
		Blusa blusa = new Blusa();
		BlusaDAO blusaDAO = new BlusaDAO(connection);
		
		blusa.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso: ")));
		blusa.setTipoTecido(JOptionPane.showInputDialog("Tipo tecido: "));
		
		System.out.println(blusaDAO.DeletarBlusa(blusa));
		
		Conexao.fecharConexao(connection);
	}
	
	public static void SelectBlusa()
	{
		Connection connection = Conexao.abrirConexao();
		BlusaDAO blusaDAO = new BlusaDAO(connection);

		ArrayList<Blusa> lista = blusaDAO.retornarDadosBlusa();

		if (lista != null) {
			for (Blusa blusa : lista) {
				System.out.println("Peso do blusa: " + blusa.getPeso());
				System.out.println("Tecido do blusa: " + blusa.getTipoTecido());
				System.out.println("Possui touca: " + blusa.isTouca());
				System.out.println("\n");
				
			}
		}
		Conexao.fecharConexao(connection);
	}
	
	public static void DeleteAll() 
	{
		Connection connection = Conexao.abrirConexao();
		
		BlusaDAO blusaDAO = new BlusaDAO(connection);
		
		System.out.println(blusaDAO.DeletarAllBlusas());
		
		Conexao.fecharConexao(connection);
	}
}
