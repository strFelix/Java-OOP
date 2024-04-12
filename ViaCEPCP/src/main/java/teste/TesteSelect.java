package teste;

import java.sql.Connection;
import java.util.ArrayList;

import conexao.Conexao;
import dao.EnderecoDAO;
import model.Endereco;

public class TesteSelect {

	public static void main(String[] args) {

		Connection connection = Conexao.abrirConexao();
		EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
		
		ArrayList<Endereco> lista = enderecoDAO.retornarEnderecos();

		if (lista != null) {
			for (Endereco endereco : lista) {
				System.out.println(endereco.getCep());
				System.out.println(endereco.getLogradouro());
				System.out.println(endereco.getLocalidade());
				System.out.println(endereco.getComplemento());
				System.out.println(endereco.getBairro());
				System.out.println(endereco.getLocalidade());
				System.out.println(endereco.getUf());
				System.out.println(endereco.getIbge());
				System.out.println(endereco.getGia());
				System.out.println(endereco.getSiafi());
				System.out.println("\n");
				
			}
		}
		
		Conexao.fecharConexao(connection);
			
	}
}



