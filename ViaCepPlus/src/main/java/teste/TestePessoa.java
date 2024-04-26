package teste;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dao.PessoaDAO;
import model.Pessoa;

public class TestePessoa {

	public static void main(String[] args) {
		
		int choice  = Integer.parseInt(JOptionPane.showInputDialog("1 - insert | 2 - select *"));
		switch (choice) {
		case 1: 
		{
			InserirPessoa();
			break;
		}
		case 2: 
		{
			SelectPessoa();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
			
		}
		
	}
	
	public static void SelectPessoa()
	{
		Connection connection = Conexao.abrirConexao();
		PessoaDAO pessoaDAO = new PessoaDAO(connection);

		ArrayList<Pessoa> lista = pessoaDAO.retornarDadosPessoa();
		if (lista != null) {
			for (Pessoa pessoa: lista) {
				System.out.println(pessoa.getCpf());
				System.out.println(pessoa.getNome());
				System.out.println(pessoa.getIdade());
				
				System.out.println("\n");
				
			}
		}
		Conexao.fecharConexao(connection);
	}
	
	public static Pessoa InserirPessoa()
	{
		Connection con = Conexao.abrirConexao();
		PessoaDAO pessoadao = new PessoaDAO(con);
		Pessoa  pessoa = new Pessoa();
		
		pessoa.setCpf(Integer.parseInt(JOptionPane.showInputDialog("Cpf")));
		pessoa.setNome(JOptionPane.showInputDialog("Nome"));
		pessoa.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade")));
		
		System.out.println(pessoadao.inserir(pessoa));
		Conexao.fecharConexao(con);
		return(pessoa);
	}
}