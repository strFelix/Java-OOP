//lucas felix
package teste;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConexaoLucasFelix;
import dao.EnderecoDAOLucasFelix;
import dao.ProfessorDAOLucasFelix;
import model.EnderecoLucasFelix;
import model.ProfessorLucasFelix;
import service.ViacepServiceLucasFelix;

public class TesteLucasFelix {

	public static void main(String[] args) {

		int choice  = Integer.parseInt(JOptionPane.showInputDialog("1 - insert | 2 - update | 3 - select * | 4 - delete all"));
		switch (choice) {
		case 1: 
		{
			InsertProfessor();
			break;
		}
		case 2: 
		{
			UpdateProfessor();
			break;
		}
		case 3: 
		{
			SelectProfessor();
			break;
		}
		case 4: 
		{
			DeleteAllProfessor();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
			
		}
		
	}
	
	public static void InsertProfessor()
	{
		Connection con = ConexaoLucasFelix.abrirConexao();
		EnderecoDAOLucasFelix enderecodao = new EnderecoDAOLucasFelix(con);
		ProfessorDAOLucasFelix professordao = new ProfessorDAOLucasFelix(con);
		ViacepServiceLucasFelix viacepservice = new ViacepServiceLucasFelix();

		try {
			EnderecoLucasFelix  endereco = viacepservice.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));
			
			ProfessorLucasFelix professor = new ProfessorLucasFelix();
			professor.setCpf(JOptionPane.showInputDialog("CPF:"));
			endereco.setCpfPessoa(professor.getCpf());
			
			professor.setNome(JOptionPane.showInputDialog("Nome:"));
			professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade:")));
			professor.setRg(JOptionPane.showInputDialog("RG:"));
			professor.setEndereco(endereco);
			professor.setValorHoraAula(Double.parseDouble(JOptionPane.showInputDialog("Valor hora aula:")));
			professor.setMateria(JOptionPane.showInputDialog("Materia:"));
			professor.setAnosEscola(Integer.parseInt(JOptionPane.showInputDialog("Anos de escola:")));
			professor.setPeriodo(JOptionPane.showInputDialog("Periodo:"));
			
			
			
			System.out.println(enderecodao.inserir(endereco) + "\n" + professordao.inserir(professor));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void DeleteAllProfessor()
	{
		Connection connection = ConexaoLucasFelix.abrirConexao();
		
		ProfessorDAOLucasFelix professorDAOLucasFelix = new ProfessorDAOLucasFelix(connection);
		
		System.out.println(professorDAOLucasFelix.DeletarAllProfessor());
		
		ConexaoLucasFelix.fecharConexao(connection);
	}
	
	public static void UpdateProfessor()
	{
		Connection connection = ConexaoLucasFelix.abrirConexao();
		
		ProfessorLucasFelix professor = new ProfessorLucasFelix();
		ProfessorDAOLucasFelix professorDAO = new ProfessorDAOLucasFelix(connection);
		
		professor.setAnosEscola(Integer.parseInt(JOptionPane.showInputDialog("Anos de escola: ")));
		professor.setCpf(JOptionPane.showInputDialog("CPF: "));
		
		System.out.println(professorDAO.UpdateProfessor(professor));
		
		ConexaoLucasFelix.fecharConexao(connection);
	}
	
	public static void SelectProfessor()
	{
		Connection connection = ConexaoLucasFelix.abrirConexao();
		ProfessorDAOLucasFelix professorDAO = new ProfessorDAOLucasFelix(connection);

		ArrayList<ProfessorLucasFelix> lista = professorDAO.retornarDadosProfessor();
		//cpf, nome, idade, rg, valorHora, materia, anosEscola, periodo
		if (lista != null) {
			for (ProfessorLucasFelix professor : lista) {
				System.out.println(professor.getCpf());
				System.out.println(professor.getNome());
				System.out.println(professor.getIdade());
				System.out.println(professor.getRg());
				System.out.println(professor.getValorHoraAula());
				System.out.println(professor.getMateria());
				System.out.println(professor.getAnosEscola());
				System.out.println(professor.getPeriodo());
				System.out.println("\n");
				
			}
		}
		ConexaoLucasFelix.fecharConexao(connection);
	}
		
}


	
	

