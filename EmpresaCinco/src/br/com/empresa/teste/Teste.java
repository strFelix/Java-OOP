package br.com.empresa.teste;

import javax.swing.JOptionPane;

import br.com.empresa.beans.Funcionario;

public class Teste {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(JOptionPane.showInputDialog("Digite seu nome:"));
		funcionario.setSexo(JOptionPane.showInputDialog("Qual o seu sexo:"));
		funcionario.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:")));
		funcionario.setCargo(JOptionPane.showInputDialog("Digite seu cargo:"));
		
		funcionario.mostrarAtributo();
	}

}
