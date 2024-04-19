//lucas felix
package model;

public class ProfessorLucasFelix extends PessoaLucasFelix {
	private Double valorHoraAula;
	private String materia;
	private int anosEscola;
	private String periodo;
	
	public Double getValorHoraAula() {
		return valorHoraAula;
	}
	public void setValorHoraAula(Double valorHoraAula) {
		this.valorHoraAula = valorHoraAula;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getAnosEscola() {
		return anosEscola;
	}
	public void setAnosEscola(int anosEscola) {
		this.anosEscola = anosEscola;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
