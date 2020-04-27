package Av1Poo;

import java.util.Scanner;

public class Empresa extends PessoaJuridica implements Login{
	
	//ATRIBUTOS
	private int idEmpresa;
	private int senha;
	
	// METODO CONSTRUTOR
	
	public Empresa() {
		super();
		this.idEmpresa = 0;
		this.senha = 0;
	}
	
	// METODOS ACESSORES GET / SET
	
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	// FIM DOS METODOS ACESSORES GET / SET
	
	// INICIO METODOS SOBREPOSIÇAO
	
	
	//INICIO DO METODO PARA CADASTRAR SENHA IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public void cadastraSenha() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("### CADASTRO DE SENHA  ###");
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
						}// FIM DO ELSE 
				}else { 
						System.out.printf("LOGIN  OU CNPJ INVALIDO");
						System.out.println(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n");
						continuar = teclado.nextInt();
					}
			}// FIM DO wHILE
	
	}// FIM DO METODO

	//INICIO DO METODO PARA FAZER LOGIN IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public void fazerLogin() {
		Scanner teclado = new Scanner(System.in);
			System.out.printf("\n ### EMPRESA ### \n");
			 int continuar = 1; 
					while(continuar  == 1) {
						
						if(validaLogin()== true && validaSenha() == true) {
							System.out.printf(" ###BEM VINDO AO GIOCONDA ### \n \t" + this.getRazaoSocial() + "\n\n");
							continuar = 0;
						} else { 
							System.out.printf("LOGIN OU SENHA INVALIDO :( \n ESQUECI A SENHA \n"); 
							System.out.printf(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n 2 = ESQUECI A SENHA \n\n "); 
					 		continuar = teclado.nextInt();
							
								if(continuar == 2) {
									cadastraSenha();
								}
						}
					} // FIM DO WHILE 	
	}// FIM DO METODO
	
	//INICIO DO METODO PARA VALIDAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
	@Override
	public boolean validaLogin() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("LOGIN");
			int L = teclado.nextInt();
			if(L == getIdEmpresa()) {
				return true;
			} else {
				return false;
			}
	}// FIM DO METODO
	
	// INICIO DO METODO PARA VALIDAR LOGIN IMPLEMENTADA DA INTERFACE LOGIN
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
	
	// INICIO DO METODO PARA VALIDAR CPF IMPLEMENTADA DA INTERFACE LOGIN 
	@Override
	public boolean validaCpf() {
		Scanner teclado = new Scanner(System.in);
			System.out.println("DIGITE O CNPJ DA EMPRESA \n");
			String C = teclado.next();
			if(C.contentEquals(getCnpj()) ) {
				return true;
			}else {
				return false;
			}
	}// FIM DO METODO 

	@Override
	public int geraMatricula() {
		// TODO Auto-generated method stub
		return 0;
	}
		
}// FIM DA CLASSE
