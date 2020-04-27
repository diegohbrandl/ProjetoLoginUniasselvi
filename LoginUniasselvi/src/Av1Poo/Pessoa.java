package Av1Poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//CLASSE ABSTRATA NAO PODENDO SER INSTANCIADA
public abstract class Pessoa {
	
	//ATRIBUTOS 
	
	private String nome ;			
	private Date dataNascimento; 
	private String estadoCivil;
	private String sexo ;
	protected String email;
	
	
	//METODO CONSTRUTOR
	public Pessoa(){
		this.nome = "";
		this.dataNascimento = new Date ();
		this.estadoCivil = "";
		this.sexo = "";
		this.email = "";
		
	
	} // FIM METODO CONSTRUTOR
	
	
	// METODOS PRINCIPAIS
	
	public String getInformacaoDados()  {	//METODO PARA RETORNAR AS INFORMAÇOES CADASTRADAS PELO USUARIO
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
		return  " Nome -->>>>> " + this.getNome() +
				"\n Data Nascimento -->>>>> " + formatoBrasileiro.format(dataNascimento) +
				"\n Estado Civil -->>>>> " + this.getEstadoCivil() +
				"\n Sexo -->>>>>>> " + this.sexo +
				"\n Email -->>>>>> " + this.email;
				
		
	}// FIM DO METODO getInformacaoDados
	
	public void cadastra() throws ParseException { 	// METODO PARA CADASTRAR USUARIOS
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy"); // FORMATAÇAO DA DATA PARA O FORMATO BRASILEIRO
		Scanner teclado = new Scanner(System.in);
			System.out.println("Nome: " ); 
			setNome(teclado.nextLine());
			System.out.println("Data Nascimento: " );
			String dt = teclado.nextLine();
			setDataNascimento(formatoBrasileiro.parse(dt));  
			System.out.println("Estado Civil: " );
			setEstadoCivil(teclado.nextLine());
			System.out.println("Sexo: " );
			setSexo(teclado.nextLine());
			System.out.println("Email: " );
			setEmail(teclado.nextLine());
			
	
	}	// FIM DO METODO getCadastropessoa
	
	//FIM DOS METODOS PRINCIPAIS
	
	// INICIO METODO ACESSORES GET / SET
	
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getEstadoCivil() {
			return estadoCivil;
		}
		public void setEstadoCivil(String estadoCivil) {
			this.estadoCivil = estadoCivil;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		
		// FIM DOS METODOS ACESSORES GET / SET
		
} // FIM DA CLASSE PESSOA
