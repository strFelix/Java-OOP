package br.com.construtora.teste;

import javax.swing.JOptionPane;

import br.com.construtora.models.Apartamento;
import br.com.construtora.models.Casa;

public class Teste {

	public static void main(String[] args) {
		
		System.out.println("--------------------------");
		System.out.println("1 - Apartamento | 2 - Casa");
		System.out.println("--------------------------");
		int choice = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:"));
		
		switch(choice){
		case 1:
			Apartamento apartamento = new Apartamento();
			
			apartamento.setNome(JOptionPane.showInputDialog("Nome do apartamento: "));
			apartamento.setMetrosQuadrados(Double.parseDouble(JOptionPane.showInputDialog("Metros quadrados: ")));
			apartamento.setQuantidadeQuartos(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de quartos: ")));
			apartamento.setQuantidadeVarandas(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de varandas: ")));

			System.out.println(String.format("Apartamento: Nome: %s \nM²: %f \nQuartos: %d \nVarandas: %d \n", apartamento.getNome(), apartamento.getMetrosQuadrados(), apartamento.getQuantidadeQuartos(), apartamento.getQuantidadeVarandas()));
			
		case 2:
			
			Casa casa = new Casa();

			casa.setNome(JOptionPane.showInputDialog("Nome do casa: "));
			casa.setMetrosQuadrados(Double.parseDouble(JOptionPane.showInputDialog("Metros quadrados: ")));
			casa.setQuantidadeQuartos(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de quartos: ")));
			casa.setMetrosQuadradosGaragem(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de metros da garagem: ")));
			
			System.out.println(String.format("Casa: Nome: %s \nM²: %f \nQuartos: %d \nM² Garagem: %d", casa.getNome(), casa.getMetrosQuadrados(), casa.getQuantidadeQuartos(), casa.getMetrosQuadradosGaragem()));
			
		default:
			System.out.println("## Escolha indisponivel ##");
			break;
	}
		
		
		
	}
}
