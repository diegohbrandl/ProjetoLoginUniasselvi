package Av1Poo;

import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Colaborador extends Funcionario implements Login{
	//ATRIBUTOS
	private int horasTrabalho;
	private String poloAtuacao;
	private String turno;
	private int senha;
	private int idFuncionario;
	
	//METODO CONSTRUTOR
	
	public Colaborador() {
		super();
		this.horasTrabalho = 0;
		this.poloAtuacao = "";
		this.turno = "";
		this.senha = 0;
		this.idFuncionario = 0;
	}
	
	// METODOS ACESSORES GET / SET
	
	public int getHorasTrabalho() {
		return horasTrabalho;
	}

	public void setHorasTrabalho(int horasTrabalho) {
		this.horasTrabalho = horasTrabalho;
	}

	public String getPoloAtuacao() {
		return poloAtuacao;
	}

	public void setPoloAtuacao(String poloAtuacao) {
		this.poloAtuacao = poloAtuacao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	// FIM DOS METODOS ACESSORES GET / SET

	//INICIO DOS METODO PRINCIPAIS
	
	//POLIMORFISMO DE HERANÇA DA  CLASSE FUNCIONARIO
	// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
	public  String getInformacaoDados()  {
		String informacao = super.getInformacaoDados(); 
		return informacao + 
				"\n Horas Trabalho -->>>>> " + this.getHorasTrabalho() +
				"\n Polo Atuaçao -->>>>> " + this.getHorasTrabalho() +
				"\n Turno -->>>>>> " + this.getTurno() +
				"\n id Funcionario -->>>>>>>> " + this.idFuncionario ;
		
	}// FIM DO METODO
	
	
		//POLIMORFISMO DE HERANÇA DA  CLASSE FUNCIONARIO
		// INICIO DO METODO COM POLIMORFISMO PARA RETORNO DOS ATRIBUTOS COM ALTERAÇOES PARA ESSA CLASSE 
		public void cadastra() throws ParseException {
		 try (Scanner teclado = new Scanner(System.in)) {
			super.cadastra();
			 System.out.println("Horas de Trabalho : ");
			setHorasTrabalho(teclado.nextInt());
			 System.out.println("Polo Atuaçao: ");
			setPoloAtuacao(teclado.next());
			 System.out.println("Turno: ");
			setTurno(teclado.next());
			 System.out.println("Id: ");
			setIdFuncionario(teclado.nextInt());
		}
	}// FIM DO METODO
	
	// INICIO DOS METODOS SOBREPOSIÇAO
		
	// INICIO DO METODO PARA CADASTRAR SENHA IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public void cadastraSenha() {
		Scanner teclado = new Scanner(System.in);
			System.out.printf("\n ### CADASTRAR SENHA ###\n\n");
			int continuar = 1;
			while (continuar != 0){ // INICIO DO DO WHILE
				
				if(validaCpf() == true && validaLogin() == true && isAtivo() == true ){  
					int[] cadastraSenha = new int [2];  
					System.out.println(" INSIRA SUA SENHA ");
					cadastraSenha[0] = teclado.nextInt(); 
					System.out.println(" INSIRA A SENHA NOVAMENTE ");
					cadastraSenha[1] = teclado.nextInt(); 

					if(cadastraSenha[0] == cadastraSenha[1]) { 
						System.out.println("\n\n SENHA CADASTRADA COM SUCESSO :) \n\n");
						System.out.printf(" 0 = SAIR \n 1 = VOLTAR A PAGINA DE LOGIN \n ");
						senha = cadastraSenha[1];
						continuar = teclado.nextInt();
						
						if(continuar == 1) {
							fazerLogin();
							continuar= 0; 
						}
					}else { 
						System.out.println("SENHAS NAO CONFEREM :( \n");
						System.out.println(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n"); 
						continuar = teclado.nextInt(); 
					}
					
					}else { 
						System.out.printf("ID INVALIDO OU INATIVO :( ");
						System.out.println(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n");
						continuar = teclado.nextInt();
					}  
			}// FIM DO WHILE
		
	} // FIM DO METODO CADASTRA SENHA
		
	
	// INICIO DO METODO PARA FAZER LOGIN IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public void fazerLogin() {
		Scanner teclado = new Scanner(System.in);
			System.out.printf("\n### COLABORADOR ### \n\n");
			 int continuar = 1; 
					while(continuar  == 1) {
						
						if(validaLogin() == true && validaSenha()== true && validaCpf()== true && isAtivo() == true) {
							System.out.printf("### BEM VINDO AO GIOCONDA ### \n \t" + this.getNome() + "\n\n");  
							continuar = 0;  
						} else if(isAtivo() == false){
								System.out.println("DESCULPE VOCE NAO TEM PERMISSAO ID INATIVO");
								continuar = 0;
							}else {
								System.out.printf("LOGIN OU SENHA INVALIDO :( \n ESQUECI A SENHA \n"); 
								System.out.printf(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n 2 = ESQUECI A SENHA \n\n "); 
								continuar = teclado.nextInt();
								
									if(continuar == 2) {
										cadastraSenha();
									}
									
							}// FIM DO ELSE
					} // FIM DO WHILE  
		
			
	} // FIM DO METODO FAZER LOGIN

	// INICIO DO METODO PARA VALIDAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public boolean validaLogin() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("LOGIN ");
			int L = teclado.nextInt();
			if(L == getIdFuncionario()) {
				return true;
			} else {
				return false;
			
		}
	}// FIM DO METODO

	// INICIO DO METODO PARA VALIDAR SENHA IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public boolean validaSenha() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("SENHA");
			int S = teclado.nextInt();
			if(S == getSenha() ) {
				return true;
			}else {
				return false;
			}
		
	}// FIM DO METODO

	// INICIO DO METODO PARA VALIDAR CPF IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public boolean validaCpf() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("DIGITE SEU CPF ");
			String C = teclado.next();
			if(C.contentEquals(getCpf()) ) {
				return true;
			}else {
				return false;
			}
		
	}// FIM DO METODO

	@Override
	public int geraMatricula() {
		Random random = new Random();
		int gerarMatricula = random.nextInt(100000);
		idFuncionario = gerarMatricula;
		return idFuncionario;
	}

		
}// FIM DA CLASSE
	

