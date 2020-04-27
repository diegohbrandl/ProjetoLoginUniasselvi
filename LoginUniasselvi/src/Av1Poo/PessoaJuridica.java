package Av1Poo;

import java.text.ParseException;
import java.util.Scanner;

//CLASSE ABSTRATA NAO PODENDO SER INSTANCIADA
public abstract class PessoaJuridica extends Pessoa{
	//ATRIBUTOS
	private String razaoSocial;
	private String cnpj;
	
	// INICIO METODOS ACESSORES GET / SET
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	// FIM DOS METODOS ACESSORES GET/ SET
	
	//INICIO DOS METODO PRINCIPAIS
	//POLIMORFISMO DE HERANÇA DA  CLASSE PESSOA
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public  String getInformacaoDados()  {
		String informacao = super.getInformacaoDados();
		return informacao +
				"\n Razao Social: " + this.getRazaoSocial() +
				"\n Cnpj: " + this.getCnpj();
		
	}// FIM DO METODO
	
		//POLIMORFISMO DE HERANÇA DA  CLASSE PESSOA
		// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public void cadastra() throws ParseException {
		Scanner teclado = new Scanner(System.in);
			super.cadastra();
			System.out.println("Razao Social: ");
			setRazaoSocial(teclado.nextLine());
			System.out.println("CNPJ: ");
			setCnpj(teclado.next());

	}// FIM DO METODO

}// FIM DA CLASSE


