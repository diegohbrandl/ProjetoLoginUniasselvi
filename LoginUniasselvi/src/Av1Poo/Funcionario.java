package Av1Poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// CLASSE ABSTRATA NAO PODENDO SER INSTANCIADA
public abstract class Funcionario extends PessoaFisica{
	
	//ATRIBUTOS
	private String cargo;
	private float salario;
	private Date dataAdmissao;
	private String carteiraTrabalho;
	private boolean ativo;
	
	// METODO CONSTRUTOR
	
		public Funcionario() {
			super();
			this.cargo = "";
			this.salario = 0.0f;
			this.dataAdmissao = new Date();
			this.carteiraTrabalho = "";
			this.ativo = false;
		}
		
	//INICIO	METODOS ACESSORES GET / SET
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	//FIM DOS METODOS ACESSORES GET / SET
	
	
	//INICIO DOS METODO PRINCIPAIS
	//POLIMORFISMO DE HERANÇA DA  CLASSE PESSOAFISICA
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public String getInformacaoDados()  {
		String informacao = super.getInformacaoDados(); 
		return informacao + 
				"\n Cargo -->>>>> " + this.getCargo() +
				"\n Salario -->>>>> " + this.getSalario()+
				"\n Data de Admissao -->>>>>> " + this.getDataAdmissao() +
				"\n carteira de Trabalho -->>>>>> " + this.getCarteiraTrabalho()+
				"\n Funcionario Ativo -->>>>>> " + this.isAtivo();
		
	}// FIM DO METODO
	// POLIMORFISMO DE HERANÇAO DA  CLASSE PESSOAFISICA
	// INICIO DO METODO COM POLIMORFISMO PARA CADASTRO COM ALTERAÇOES PARA ESSA CLASSE 
	public void cadastra() throws ParseException {
		Scanner teclado = new Scanner(System.in);
			SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy"); // RECEBE A DATA NO FORMATO BRASILEIRO
			super.cadastra();
			System.out.println("Cargo: ");
			setCargo(teclado.next());
			System.out.println("Salario: ");
			setSalario(teclado.nextInt());
			System.out.println("DataAdmissao: ");
			String dt = teclado.next();
			setDataNascimento(formatoBrasileiro.parse(dt));  
			System.out.println("Carteira Trabalho: ");
			setCarteiraTrabalho(teclado.next());
		setAtivo(true);

	}// FIM DO METODO

}//FIM DA CLASSE	

