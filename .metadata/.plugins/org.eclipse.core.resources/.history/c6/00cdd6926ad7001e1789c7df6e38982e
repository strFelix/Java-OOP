package br.com.samsung.teste;

import javax.swing.JOptionPane;

import br.com.samsung.models.Celular;
import br.com.samsung.models.LinhaBranca;

public class TesteDois {

	public static void main(String[] args) {
		System.out.println("------------------------------");
		System.out.println("1 - Linha Branca | 2 - Celular");
		System.out.println("------------------------------");
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:"));
		
		switch(choice){
			case 1:
				Celular novoCeluar = new Celular();
				
				novoCeluar.setNome(JOptionPane.showInputDialog("Nome do celular: "));
				novoCeluar.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso do celular: ")));
				novoCeluar.setLarguraTela(Double.parseDouble(JOptionPane.showInputDialog("Largura do celular: ")));
				novoCeluar.setAlturaTela(Double.parseDouble(JOptionPane.showInputDialog("Altura do celular: ")));
				System.out.println(String.format("Nome: %s \nPeso: %.1f \nLargura: %.1f \nAltura: %.1f", novoCeluar.getNome(), novoCeluar.getPeso(), novoCeluar.getLarguraTela(), novoCeluar.getAlturaTela()));
				break;
			case 2:
				LinhaBranca novoLinhaBranca = new LinhaBranca();
				novoLinhaBranca.setNome(JOptionPane.showInputDialog("Nome do aparelho: "));
				novoLinhaBranca.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Peso do aparelho: ")));
				novoLinhaBranca.setTipo(JOptionPane.showInputDialog("Tipo do aparelho: "));
				System.out.println(String.format("Nome: %s \nPeso: %.1f \nTipo: %s", novoLinhaBranca.getNome(), novoLinhaBranca.getPeso(), novoLinhaBranca.getTipo()));
				break;
			default:
				System.out.println("## Escolha indisponivel ##");
				break;
		}
	}
}
