package Av1Poo;

import java.text.ParseException;
import java.util.Scanner;

public class Coordenador extends Colaborador { // HERANÇA DA CLASSE PROFESSOR
	
	// ATRIBUTOS
	private String disciplinaRegente;
	private int numeroProfessorGerencia;
	
	// METODO CONSTRUTOR
	
	public Coordenador() {
		super();
		this.disciplinaRegente = "";
		this.numeroProfessorGerencia = 0 ;
		
	}// FIM DO METODO CONSTRUTOR
	
	
	// INICIO DOS METODOS ACESSORES GET / SET
	public String getDisciplinaRegente() {
		return disciplinaRegente;
	}

	public void setDisciplinaRegente(String disciplinaRegente) {
		this.disciplinaRegente = disciplinaRegente;
	}

	public int getNumeroProfessorGerencia() {
		return numeroProfessorGerencia;
	}

	public void setNumeroProfessorGerencia(int numeroProfessorGerencia) {
		this.numeroProfessorGerencia = numeroProfessorGerencia;
	}
	
	// FIM DOS METODOS ACESSORES GET / SETS
	
	// INICIO DOS METODOS PRINCIPAIS
	
	// POLIMORFISMO DA CLASSE PROFESSOR
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS  PESSOAS COM ALTERAÇOES DOS ATRIBUTOS DA CLASSE PROFESSOR
	public String getInformacaoDados()  {
		String informacao = super.getInformacaoDados(); 
		return informacao + 
				"\n Disciplina que Regente -->>>>> " + this.disciplinaRegente +
				"\n Quantidade de Professor que Regente -->>>>> " + this.numeroProfessorGerencia;
	}// FIM DO METODO 
	
	// POLIMORFISMO DA CLASSE PROFESSOR 
	//INICIO DO METODO 
	public void cadastra() throws ParseException {
		Scanner teclado = new Scanner(System.in);
			super.cadastra();
			System.out.println("Disciplina Regente : ");
			setDisciplinaRegente(teclado.next());
			System.out.println("Numero de professor que e Regente: ");
			setNumeroProfessorGerencia(teclado.nextInt());

	}// FIM DO METODO

}// FIM DA CLASSE
