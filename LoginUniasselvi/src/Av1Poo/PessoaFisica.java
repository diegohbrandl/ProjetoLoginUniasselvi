package Av1Poo;

import java.text.ParseException;
import java.util.Scanner;

//CLASSE ABSTRATA NAO PODENDO SER INSTANCIADA
public abstract class PessoaFisica extends Pessoa{
	
	//ATRIBUTOS
	private String cpf;
	private String rg;
	
	// METODO CONSTRUTOR
	
	public PessoaFisica() {
		super();
		this.cpf = "" ;
		this.rg = "" ;
		
	}
	
	//METODOS ACESSORES GET / SET
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	//FIM DOS METODOS ACESSORES GET / SET
	
		//METODOS PRINCIPAIS
	
	//POLIMORFISMO COM A CLASSE PESSOA
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS  PESSOAS COM ALTERAÇOES DOS ATRIBUTOS DA CLASSE PESSOAFISICA
	public  String getInformacaoDados()  {   
		String informacao = super.getInformacaoDados(); // ATRIBUTO INFORMAÇAO PARA RECEBER AS INFORMAÇOES DO SUPER 
		return informacao + 						// RETORNO DA HERANÇA PESSOA + OS ADICIONAIS DA CLASSE PESSOAfISICA
				"\n Cpf -->>>>> " + this.getCpf() +
				"\n Rg -->>>>> " + this.getRg();
		
	}// FIM DO METODO 
	
	//POLIMORFISMO DA CLASSE PESSOA
	 //POLIMORFISMO PARA CADASTRO DOS ATRIBUTOS  PESSOAS COM ALTERAÇOES DOS ATRIBUTOS DA CLASSE PESSOAFISICA
	public void cadastra() throws ParseException {	// POLIMORFISMO PARA CADASTRO DE PESSOAS COM ALTERAÇOES DOS ATRIBUTOS DA CLASSE PESSOAFISICA 
		Scanner teclado = new Scanner(System.in);
			super.cadastra(); // RECEBE HERANÇA DO METODO  PARA ESSA CLASSE
			System.out.println("Cpf: ");
			setCpf(teclado.next());
			System.out.println("Rg: ");
			setRg(teclado.next());
		
	}// FIM DO METODO
	
}// FIM DA CLASSE PESSOA
