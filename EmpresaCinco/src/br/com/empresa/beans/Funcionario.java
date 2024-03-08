package br.com.empresa.beans;

public class Funcionario extends Condominio{
	private String cargo;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void mostrarAtributo() {
		System.out.println(String.format(
				"Nome: %s"
				+ "\nSexo: %s"
				+ "\nIdade: %d"
				+ "\nCargo: %s", 
				getNome(), getSexo(), getIdade(), getCargo()));
	}
}
