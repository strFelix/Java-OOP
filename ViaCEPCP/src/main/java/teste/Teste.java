package teste;

import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dao.EnderecoDAO;
import model.Endereco;
import service.ViacepService;

public class Teste {

	public static void main(String[] args) {

		ViacepService viacepservice = new ViacepService();

		try {
			
			//Endereco endereco = viacepservice.getEndereco("01538001");
			Endereco endereco = viacepservice.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));
			
			Connection connection = Conexao.abrirConexao();
			EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
			
			System.out.println("Os dados relacionados ao seu CEP são: \n" +
				endereco.getCep() + "\n" +	
				endereco.getLocalidade() + "\n" +
				endereco.getComplemento() + "\n" +
				endereco.getBairro() + "\n" +
				endereco.getLocalidade() + "\n" +
				endereco.getUf() + "\n" +
				endereco.getIbge() + "\n" +
				endereco.getGia() + "\n" +
				endereco.getDdd() + "\n" +
				endereco.getSiafi() + "\n"
					);
		
			
			System.out.println(enderecoDAO.inserirEndereco(endereco));
			
			Conexao.fecharConexao(connection);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}



