package br.com.primeiroexercicio.teste;

import javax.swing.JOptionPane;

import br.com.primeiroexercicio.beans.Mamifero;

public class Teste {

	public static void main(String[] args) {
		
		Mamifero mamifero = new Mamifero();
		
		mamifero.setEspecie(JOptionPane.showInputDialog("Digite a espécie:"));
		mamifero.setNome(JOptionPane.showInputDialog("Digite o nome:"));
		mamifero.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a idade:")));
		mamifero.setMesesGestacao(Integer.parseInt(JOptionPane.showInputDialog("Digite os meses de gestação:")));
		
		System.out.println(String.format(
				"A espécie é %s. "
				+ "\nO nome do amimal é %s. "
				+ "\nA idade do animal é %d. "
				+ "\nMeses de gestação do animal é %d.", 
				mamifero.getEspecie(), mamifero.getNome(), mamifero.getIdade(), mamifero.getMesesGestacao()));
	}

}
