package Av1Poo;

import java.text.ParseException;
import java.util.Scanner;

public class Professor extends Colaborador {
	
	// ATRIBUTOS
	private float horaAula;
	private String disciplinaAtuacao;
	private String tipoAtuacao;
	
	
	// METODO CONSTRUTOR
	
	public Professor() {
		super();
		this.horaAula = 0;
		this.disciplinaAtuacao = "";
		this.tipoAtuacao = "";
		
	}

	// INICIO METODOS ACESSORES GET / SET
	public float getHoraAula() {
		return horaAula;
	}

	public void setHoraAula(float horaAula) {
		this.horaAula = horaAula;
	}

	public String getDisciplinaAtuacao() {
		return disciplinaAtuacao;
	}

	public void setDisciplinaAtuacao(String disciplinaAtuacao) {
		this.disciplinaAtuacao = disciplinaAtuacao;
	}

	public String getTipoAtuacao() {
		return tipoAtuacao;
	}

	public void setTipoAtuacao(String tipoAtuacao) {
		this.tipoAtuacao = tipoAtuacao;
	}
	// FIM DOS METODOS ACESSORES GET / SET
	
	// INICIO DOS METODOS PRINCIPAIS
	
	//POLIMORFISMO DE HERANÇA DA  CLASSE FUNCIONARIOPOLO
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public String getInformacaoDados()  {
		String informacao = super.getInformacaoDados(); 
		return informacao + 
				"\n Horas de Aula -->>>>> " + this.horaAula +
				"\n Disciplina de Atuaçao -->>>>> " + this.disciplinaAtuacao+
				"\n Tipo de Atuacao -->>>>>> " + this.tipoAtuacao;
		
	}// FIM DO METODO
	
	//POLIMORFISMO DE HERANÇA DA  CLASSE FUNCIONARIOPOLO
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public void cadastra() throws ParseException {
		Scanner teclado = new Scanner(System.in);
			super.cadastra();
			System.out.println("Horas de Aula : ");
			setHoraAula(teclado.nextInt());
			System.out.println("Disciplina(s) Atuaçao: ");
			setDisciplinaAtuacao(teclado.next());
			System.out.println("Tipo Atuaçao que exerce: ");
			setTipoAtuacao(teclado.next());
	}// FIM DO METODO

}// FIM DA CLASSE
