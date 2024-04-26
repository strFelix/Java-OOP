package teste;

import model.Pessoa;

public class TesteAll {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		System.out.println("INSERINDO PESSOA...");
		pessoa = TestePessoa.InserirPessoa();
		System.out.println("-------------------" + "\n");
		
		System.out.println("INSERINDO ENDERECO...");
		TesteEndereco.InserirEndereco(pessoa.getCpf());
		System.out.println("---------------------" + "\n");
		
		System.out.println("SELECT ENDERECO...");
		TesteEndereco.SelectEndereco();
		System.out.println("------------------" + "\n");
		
		System.out.println("SELECT PESSOA...");
		TestePessoa.SelectPessoa();
		System.out.println("----------------" + "\n");
	}

}
