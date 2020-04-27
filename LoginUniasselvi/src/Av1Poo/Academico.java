package Av1Poo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Academico extends PessoaFisica implements Login{
	
	// ATRIBUTOS
	
	private int matricula;
	private boolean ativo; // SE ALUNO ESTA ATIVO OU NAO
	private int senha; 
	private String curso;  
	private Date dataMatricula; 
	private String turma; 	
	private String modalidadeEnsino; // EAD OU PRESENCIAL
	
	//METODO CONSTRUTOR
		
		public Academico() {
		super();
		this.matricula = 0;
		this.senha = 0;
		this.curso = "";
		this.dataMatricula = new Date();
		this.turma = "";
		this.modalidadeEnsino = "";
		this.ativo = false;
	}

	// INICIO METODOS ACESSORES GET / SET
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getModalidadeEnsino() {
		return modalidadeEnsino;
	}
	public void setModalidadeEnsino(String modalidadeEnsino) {
		this.modalidadeEnsino = modalidadeEnsino;
	}
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	// FIM DOS METODOS ACESSORES GET / SET
	
	// INICIO METODOS PRINCIPAIS
	//POLIMORFISMO DA HERANÇA PESSOA
	public  String getInformacaoDados()  { // METODO PARA RETORNAR INFORMAÇAO DOS DADOS 
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy"); // FORMATAÇAO DA DATA PARA O FORMATO BRASILEIRO
		String informacao = super.getInformacaoDados();
		return informacao +
				"\n Academico Ativo -->>>>> " + this.isAtivo() +
				"\n Numero Matricula -->>>>> " + this.getMatricula() +
				"\n Curso -->>>>>>>>> " + this.getCurso() +
				"\n Turma -->>>>> " + this.getTurma() +
				"\n Modalidade Ensino -->>>>> " + this.getModalidadeEnsino()  +
				"\n DataMatricula -->>>>> " + formatoBrasileiro.format(this.dataMatricula);	
	}// FIM DO METODO getInformacaoDados()
	
	//POLIMORFISMO DA CLASSE PESSOA
		public void cadastra() throws ParseException {	// POLIMORFISMO PARA CADASTRO DE PESSOAS COM ALTERAÇOES DOS ATRIBUTOS DA CLASSE PESSOAFISICA
			Scanner teclado = new Scanner(System.in);
				super.cadastra();; // RECEBE HERANÇA DO METODO  PARA ESSA CLASSE
				System.out.println("Curso: ");
				setCurso(teclado.nextLine());
				System.out.println("Turma: ");
				setTurma(teclado.nextLine());
				System.out.println("Modalidade Ensino");
				setModalidadeEnsino(teclado.nextLine());
				Date dtMt = new Date(System.currentTimeMillis());
				setDataMatricula(dtMt)	;
				setAtivo(true);
				geraMatricula();
			  
			
		}//FIM DO METODO 
	
	// INICIO METODOS SOBREPOSIÇAO DA INTERFACE LOGIN
	
	// INICIO DO METODO FAZER LOGIN IMPLEMENTADA DO INTERFACE
	@Override
	public void fazerLogin() { 
		Scanner teclado = new Scanner(System.in);
			int continuar = 1; 
			 		System.out.println("### ACADEMICO ###");
					while(continuar == 1){ // INICIO DO WHILE 
						if(validaLogin()== true && validaSenha() == true && isAtivo() == true) {
							System.out.printf( " ### BEM VINDO AO GIOCONDA ### \n\t " + this.getNome() + "\n\n");
							continuar = 0;
						} else if(isAtivo() == false  ){
							System.out.println("DESCULPE VOCE NAO TEM PERMISSAO ID INATIVO");
							continuar = 0; 
						}else {
							System.out.printf("LOGIN OU SENHA INVALIDO :( \n ESQUECI A SENHA \n"); 
							System.out.printf(" 0 = SAIR \n 1 = TENTAR NOVAMENTE \n 2 = ESQUECI A SENHA \n\n "); 
							continuar = teclado.nextInt();
							
							if(continuar == 2 ) {
							cadastraSenha();
							continuar = 0;
							}
						 }// FIM DO ELSE
					} // FIM DO WHILE	
		
	} // FIM DO METODO FAZER LOGIN

	// INICIO DO METODO CADASTRAR SENHA IMPLEMENTADA DO INTERFACE
	@Override
	public void cadastraSenha() { 
		 Scanner teclado = new Scanner(System.in); 
			System.out.println("### CADASTRO DE SENHA  ###");
			int continuar = 1; 	  
			while (continuar != 0) {  // INICIO DO DO WHILE
				if( validaCpf() == true && validaLogin() == true && isAtivo() == true)  {
					int[] cadastraSenha = new int [2];
					//int opcao = 0;
					System.out.println(" INSIRA SUA NOVA SENHA ");
					cadastraSenha[0] = teclado.nextInt(); 
					System.out.println(" INSIRA A SENHA NOVAMENTE NOVAMENTE ");
					cadastraSenha[1] = teclado.nextInt(); 
						if(cadastraSenha[0] == cadastraSenha[1]) { 
							System.out.println("\n\n ### SENHA CADASTRADA COM SUCESSO =) ### \n\n");
							System.out.printf(" 0 = SAIR \n 1 = VOLTAR A PAGINA DE LOGIN \n ");
							senha = cadastraSenha[1]; 
							continuar= teclado.nextInt(); 
							if(continuar == 1) {
								fazerLogin();
								continuar = 0;
							}
						}else { 
							System.out.println("SENHAS NAO CONFEREM :( \n");
							System.out.printf("0 = SAIR \n 1 = TENTAR NOVAMENTE \n"); 
							continuar = teclado.nextInt(); 
						}
					
				}else { 
					System.out.printf("LOGIN  OU CPF INVALIDO \n 0 = SAIR \n1 = TENTAR NOVAMENTE \n ");
					continuar = teclado.nextInt();
				}// FIM DO ELSE	
			}// FIM DO WHILE		
		 // TRY
	} // FIM DO METODO CADASTRA SENHA

	// INICIO DO METODO VALIDAR LOGIN IMPLEMENTADA DO INTERFACE
	@Override
	public boolean validaLogin() { // METODO PARA VALIDAR SENHA IMPLEMENTADA DA INTERFACE	
		Scanner teclado = new Scanner(System.in);
			System.out.println("LOGIN ");
			int L = teclado.nextInt();
			if(L == this.matricula) {	
				return true; 
			} else {
				return false;  
		}
	}// FIM DO METODO 

	// INICIO DO METODO VALIDAR SENHA IMPLEMENTADA DO INTERFACE
	@Override
	public boolean validaSenha() { 
		Scanner teclado = new Scanner(System.in);
			System.out.println("SENHA ");
			int S = teclado.nextInt();
			if(this.senha == S) { 
				return true; 
			}else {
				return false;
			}
	
	} // FIM DO METODO

	// INICIO DO METODO VALIDAR CPF IMPLEMENTADA DO INTERFACE
	@Override
	public boolean validaCpf() { 
		Scanner teclado = new Scanner(System.in);
			System.out.println("DIGITE SEU CPF \n");
			String C = teclado.next();
			if(C.contentEquals(getCpf())) {
				return true;	
			}else {
				return false; 	
}
		
	}// FIM DO METODO

	@Override
	public int geraMatricula() {
			Random random = new Random();
			int gerarMatricula = random.nextInt(100000);
			matricula = gerarMatricula;
			return matricula;
			
		}
	
		
} // FIM DA CLASSE ACADEMICO