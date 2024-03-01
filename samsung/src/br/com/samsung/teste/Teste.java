package br.com.samsung.teste;

import javax.swing.JOptionPane;

import br.com.samsung.models.Celular;
import br.com.samsung.models.LinhaBranca;

public class Teste {

	public static void main(String[] args) {
		Celular celular = new Celular();
		LinhaBranca linhaBranca = new LinhaBranca();
		
		linhaBranca.setNome("Geladeira Industrial");
		linhaBranca.setPeso(230);
		linhaBranca.setTipo("Geladeira");
		
		celular.setNome("S24");
		celular.setPeso(167);
		celular.setLarguraTela(7);
		celular.setAlturaTela(14.7);
		
		Celular novoCeluar = new Celular();
		LinhaBranca novoLinhaBranca = new LinhaBranca();
		
		novoCeluar.setNome(JOptionPane.showInputDialog("Nome do celular: "));
		novoCeluar.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso do celular: ")));
		novoCeluar.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Largura do celular: ")));
		novoCeluar.setAlturaTela(Double.parseDouble(JOptionPane.showInputDialog("Altura do celular: ")));
		
		novoLinhaBranca.setNome(JOptionPane.showInputDialog("Nome do aparelho: "));
		novoLinhaBranca.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso do aparelho: ")));
		novoLinhaBranca.setTipo(JOptionPane.showInputDialog("Tipo do aparelho: "));
	
		System.out.println(String.format("Celular: %s, %.1f, %.1f, %.1f", novoCeluar.getNome(), novoCeluar.getPeso(), novoCeluar.getLarguraTela(), novoCeluar.getAlturaTela()));
		System.out.println(String.format("Aparelho: %s, %.1f, %s", novoLinhaBranca.getNome(), novoLinhaBranca.getPeso(), novoLinhaBranca.getTipo()));
	}
}
