package teste;

import java.io.IOException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import conexao.ConexaoLucasFelix;
import dao.EnderecoDAOLucasFelix;
import dao.FornecedorDAOLucasFelix;
import model.EnderecoLucasFelix;
import model.FornecedorLucasFelix;
import service.ViacepServiceLucasFelix;

public class PrincipalLucasFelix {

	public static void main(String[] args) {
		try {

			// fornecedor
			Connection conLucasFelix = ConexaoLucasFelix.abrirConexao();
			FornecedorDAOLucasFelix fornecedorDaoLucasFelix = new FornecedorDAOLucasFelix(conLucasFelix);
			FornecedorLucasFelix fonecedorLucasFelix = new FornecedorLucasFelix();

			fonecedorLucasFelix.setCnpjLucasFelix(Integer.parseInt(JOptionPane.showInputDialog("CNPJ:")));
			fonecedorLucasFelix.setNomeLucasFelix(JOptionPane.showInputDialog("Nome:"));

			// endereco
			EnderecoDAOLucasFelix enderecoDaoLucasFelix = new EnderecoDAOLucasFelix(conLucasFelix);
			ViacepServiceLucasFelix viacepserviceLucasFelix = new ViacepServiceLucasFelix();
			EnderecoLucasFelix enderecoLucasFelix = new EnderecoLucasFelix();

			int cnpjLucasFelix = fonecedorLucasFelix.getCnpjLucasFelix();
			enderecoLucasFelix = viacepserviceLucasFelix.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));

			System.out.println(fornecedorDaoLucasFelix.inserir(fonecedorLucasFelix));
			System.out.println(enderecoDaoLucasFelix.inserir(enderecoLucasFelix, cnpjLucasFelix));

			ConexaoLucasFelix.fecharConexao(conLucasFelix);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}