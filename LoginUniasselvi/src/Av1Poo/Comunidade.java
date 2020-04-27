package Av1Poo;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Comunidade extends PessoaFisica implements Login{
	
	private int idComunidade;
	private int senha;

	// METODO CONSTRUTOR
	
	public Comunidade() {
		super();
		this.idComunidade = 0;
		this.senha = 0;
	}
	
	// METODOS ACESSORES GET / SET
	
			public int getSenha() {
				return senha;
			}
			public void setSenha(int senha) {
				this.senha = senha;
			}
			public int getIdComunidade() {
				return idComunidade;
			}
			public void setIdComunidade(int idComunidade) {
				this.idComunidade = idComunidade;
			}// FIM DOS METODOS ACESSORES GET / SET
			
			// METODOS PRINCIPAIS
			public String getInformacaoDados() {
				String informacao = super.getInformacaoDados();
				return informacao;
			}

		
		// METODOS DE SOBREPOSIÇAO
			//INICIO DO METODO PARA CADASTRAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
	
		public void cadastraLogin() throws ParseException {
			// MENSAGEM DO INICIO DA TELA PARA CADASTRO COMUNIDADE
			System.out.printf("### CADASTRO COMUNIDADE ### \n\n");
			SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy"); // FORMATAÇAO DA DATA PARA O FORMATO BRASILEIRO
			Scanner teclado = new Scanner(System.in);
				System.out.printf("DIGITE SEU CPF \n");
					setCpf(teclado.next());
				System.out.printf("Nome \n "); 
					setNome(teclado.next());
				System.out.printf("Sexo \n");
					setSexo(teclado.next());
				System.out.printf("Data Nascimento \n");
				String dt = teclado.next();
				setDataNascimento(formatoBrasileiro.parse(dt));
				System.out.printf("Email \n");
					email = teclado.next();
			
			geraMatricula();
				System.out.println("CADASTRO REALIZADO COM SUCESSO \n SEU ID = " + this.idComunidade + "\n\n");
				cadastraSenha();
	
		} // FIM DO METODO
			
			// METODOS SOBREPOSIÇAO
		
		// INICIO DO METODO PARA CADASTRAR SENHA IMPLEMENTADA DA INTERFACE LOGIN
		@Override
		public void cadastraSenha() { 
			Scanner teclado = new Scanner(System.in);
				System.out.println("####### CADASTRO DE SENHA  #########");
				int continuar = 1;
				while (continuar != 0) { // INICIO DO DO WHILE
					if( validaCpf() == true && validaLogin() == true )  {  
					
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
									}	continuar= 0;
							
							}else {
								System.out.println("SENHAS NAO CONFEREM :( \n");
								System.out.println(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n"); 
								continuar = teclado.nextInt();
							}
					
						}else { 
							System.out.printf("LOGIN  OU CPF INVALIDO");
							System.out.println(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n");
							continuar = teclado.nextInt();
					}// FIM DO ELSE
				}	// FIM DO WHILE
		} // FIM DO METODO

		
		//INICIO DO METODO PARA CADASTRAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
		@Override
		public void fazerLogin() {
			Scanner teclado = new Scanner(System.in);
				System.out.printf("### COMUNIDADE \n\n ");
				if(getCpf().length() == 0) {
					try {
						cadastraLogin();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				 int continuar = 1; 

				 while(continuar != 0) { // INICIO DO WHILE  
						
						if (validaLogin() == true  && validaSenha() == true && validaCpf())  { 
							System.out.printf("### BEM VINDO AO GIOCONDA ### \n \t" + this.getNome() + "\n\n");  
							continuar = 0;  
						} else { 
							System.out.printf("LOGIN OU SENHA INVALIDO :( \n ESQUECI A SENHA \n"); 
							System.out.printf(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n 2 = ESQUECI A SENHA \n\n "); 
							continuar = teclado.nextInt(); 
								if(continuar == 2) {
									cadastraSenha();
								} 
						 }
				}// FIM DO WHILE  
		}// FIM DO METODO FAZER LOGIN

		//INICIO DO METODO PARA VALIDAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
		@Override
		public boolean validaLogin() {
			Scanner teclado = new Scanner(System.in);
				System.out.println("LOGIN ");
				int L = teclado.nextInt();
				if(L == getIdComunidade()) {
					return true;
				} else {
					return false;
				}
		}// FIM DO METODO

		//INICIO DO METODO PARA VALIDAR SENHA IMPLEMENTADA DA INTERFACE LOGIN
		@Override
		public boolean validaSenha() {
			Scanner teclado = new Scanner(System.in);
				System.out.println("SENHA");
				int S = teclado.nextInt();
				if(this.senha == S) {
					return true;
				}else {
					return false;
			}
		}// FIM DO METODO

		//INICIO DO METODO PARA VALIDAR CPF IMPLEMENTADA DA INTERFACE LOGIN
		@Override
		public boolean validaCpf() {
			Scanner teclado = new Scanner(System.in);
				System.out.println("DIGITE SEU CPF \n");
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
			idComunidade = gerarMatricula;
			return idComunidade;
			
		}
	}// FIM DA CLASSE 
