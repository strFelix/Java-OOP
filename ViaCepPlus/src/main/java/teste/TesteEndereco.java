package teste;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dao.EnderecoDAO;
import model.Endereco;
import service.ViacepService;

public class TesteEndereco {

	public static void main(String[] args) {
		
		int choice  = Integer.parseInt(JOptionPane.showInputDialog("1 - insert | 2 - select *"));
		switch (choice) {
		case 1: 
		{
			int cpf = (Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF")));
			InserirEndereco(cpf);
			break;
		}
		case 2: 
		{
			SelectEndereco();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
			
		}
		
	}
	
	public static void SelectEndereco()
	{
		Connection connection = Conexao.abrirConexao();
		EnderecoDAO enderecoDAO = new EnderecoDAO(connection);

		ArrayList<Endereco> lista = enderecoDAO.retornarDadosEndereco();
		//cpf, cep, logradouro, complemento, bairro, localidade, uf, ibge, gia, ddd, siafi
		if (lista != null) {
			for (Endereco endereco: lista) {
				System.out.println(endereco.getCpf());
				System.out.println(endereco.getCep());
				System.out.println(endereco.getLogradouro());
				System.out.println(endereco.getComplemento());
				System.out.println(endereco.getComplemento());
				System.out.println(endereco.getBairro());
				System.out.println(endereco.getLocalidade());
				System.out.println(endereco.getUf());
				System.out.println(endereco.getIbge());
				System.out.println(endereco.getGia());
				System.out.println(endereco.getDdd());
				System.out.println(endereco.getSiafi());
				
				System.out.println("\n");
				
			}
		}
		Conexao.fecharConexao(connection);
	}
	
	public static void InserirEndereco(int cpf)
	{
		Connection con = Conexao.abrirConexao();
		EnderecoDAO enderecodao = new EnderecoDAO(con);
		ViacepService viacepservice = new ViacepService();
		Endereco  endereco = new Endereco();
		
		try {
			//Endereco endereco = viacepservice.getEndereco("01538001");
			//endereco.setCpf(Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF")));
			endereco.setCpf(cpf);
			endereco = viacepservice.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));
			
			System.out.println(enderecodao.inserir(endereco));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
	}
}