package br.com.etec.teste;

import java.sql.Connection;

import br.com.etec.conexao.Conexao;
import br.com.etec.dao.PessoaDAO;
import br.com.etec.model.Pessoa;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = Conexao.abrirConexao();
		
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO(connection);
		
		pessoa.setNome("Mates");
		pessoa.setEndereco("XXXXXXX");
		
		System.out.println(pessoaDAO.inserir(pessoa));
		
		Conexao.fecharConexao(connection);
	}

}
