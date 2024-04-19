//lucas felix
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ProfessorLucasFelix;


public class ProfessorDAOLucasFelix {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public ProfessorDAOLucasFelix(Connection con) {
		setCon(con);
	}

	public String inserir(ProfessorLucasFelix professor) {
		String sql = "insert into professor(cpf, nome, idade, rg, valorHora, materia, anosEscola, periodo) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, professor.getCpf());
			ps.setString(2, professor.getNome());
			ps.setInt(3,  professor.getIdade());
			ps.setString(4, professor.getRg());
			ps.setDouble(5, professor.getValorHoraAula());
			ps.setString(6,  professor.getMateria());
			ps.setInt(7, professor.getAnosEscola());
			ps.setString(8, professor.getPeriodo());
			if (ps.executeUpdate() > 0) {
				return "Professor inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String DeletarAllProfessor() {
		String sql = "delete from professor ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			if(ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			}
			else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String UpdateProfessor(ProfessorLucasFelix professor) {
		String sql = "update professor set anosEscola = (?) where cpf = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, professor.getAnosEscola());
			ps.setString(2, professor.getCpf());
			if(ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			}
			else {
				return "Erro ao deletar";
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	//cpf, nome, idade, rg, valorHora, materia, anosEscola, periodo
	public ArrayList<ProfessorLucasFelix> retornarDadosProfessor(){
		String sql = "select * from professor";
		ArrayList<ProfessorLucasFelix> retornarDadosProfessor = new ArrayList<ProfessorLucasFelix>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while(rs.next()) {
					ProfessorLucasFelix professor = new ProfessorLucasFelix();
					professor.setCpf(rs.getString(1));
					professor.setNome(rs.getString(2));
					professor.setIdade(rs.getInt(3));
					professor.setRg(rs.getString(4));
					professor.setValorHoraAula(rs.getDouble(5));
					professor.setMateria(rs.getString(6));
					professor.setAnosEscola(rs.getInt(7));
					professor.setPeriodo(rs.getString(8));
					retornarDadosProfessor.add(professor);
				} return retornarDadosProfessor;
			} else {
				return null;
			}
		} catch(SQLException e) {
			return null;
		}
	}
	

}