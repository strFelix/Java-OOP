package br.com.construtora.models;

public class Imovel {
	private String nome;
	private double metrosQuadrados;
	private int quantidadeQuartos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getMetrosQuadrados() {
		return metrosQuadrados;
	}
	public void setMetrosQuadrados(double metrosQuadrados) {
		this.metrosQuadrados = metrosQuadrados;
	}
	public int getQuantidadeQuartos() {
		return quantidadeQuartos;
	}
	public void setQuantidadeQuartos(int quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}
	
}
