package Av1Poo;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
	
	static Scanner teclado = new Scanner(System.in);
	static int valorInicio = 0;
	static int	continuar = 6;	  
	
	public static void main(String[] args) throws ParseException {
		// TESTAR ACADEMICO 
		Academico[] academico = new Academico[2]; 
		academico[0] = new Academico();
		academico[1] = new Academico();
		// INSTANCIAR ACADEMICO 1
		academico[0].setNome("Henrique Amorin");
		academico[0].setCpf("11188866645");
		academico[0].setMatricula(167823);
		academico[0].setSenha(161206);
		academico[0].setAtivo(true);
		// INSTANCIAR ACADEMICO 2
		academico[1].setNome("Galvao Bueno");
		academico[1].setCpf("98712365499");
		academico[1].setMatricula(136798);
		academico[1].setSenha(240586);
		academico[1].setAtivo(false);
		// INSTANCIAR COLABORADOR
		Colaborador[] colaborador = new Colaborador[2];
		colaborador[0] = new Colaborador();
		colaborador[1] = new Colaborador();
		//INSTANCIAR COLABORADOR 1
		colaborador[0].setNome("Martine Soarez de Lima");
		colaborador[0].setCpf("98765432100");
		colaborador[0].setIdFuncionario(989812);
		colaborador[0].setSenha(123456);
		colaborador[0].setAtivo(true);
		// INSTANCIAR COLABORADOR 2
		colaborador[1].setNome("Barbara Schimith");
		colaborador[1].setCpf("01020312366");
		colaborador[1].setIdFuncionario(1459356);
		colaborador[1].setSenha(123987);
		colaborador[1].setAtivo(false);
		// INSTANCIAR PROFESSOR
		Professor[] professor = new Professor[2];
		professor[0] = new Professor();
		professor[1] = new Professor();
		// INSTANCIAR PROFESSOR 1
		professor[0].setNome("Paulo Cesar Vasconcelos");
		professor[0].setCpf("22233344400");
		professor[0].setIdFuncionario(444777);
		professor[0].setSenha(987654);
		professor[0].setAtivo(true);
		// INSTANCIAR PROFESSOR 2
		professor[1].setNome("Alina Farias");
		professor[1].setCpf("22256789066");
		professor[1].setIdFuncionario(678900);
		professor[1].setSenha(102030);
		professor[1].setAtivo(false);
		// INSTANCIAR COORDENADOR
		Coordenador coordenador = new Coordenador();
		coordenador.setNome("Jenifer Stankislwo");
		coordenador.setCpf("77711122200");
		coordenador.setIdFuncionario(908070);
		coordenador.setSenha(222333);
		coordenador.setAtivo(true);
		//INSTANCIAR EMPRESA 
		Empresa[] empresa = new Empresa[2];
		empresa[0] = new Empresa();
		empresa[1] = new Empresa();
		//INSTANCIAR EMPRESA 1
		empresa[0].setRazaoSocial("OrganizaÃ§oes Tabajara Ltda");
		empresa[0].setCnpj("1234567890001");
		empresa[0].setIdEmpresa(999888);
		empresa[0].setSenha(999888);
		// INSTANCIAR EMPRESA 2
		empresa[1].setRazaoSocial("Mariri Incorporaction Ltda");
		empresa[1].setCnpj("871238990001");
		empresa[1].setIdEmpresa(567890);
		empresa[1].setSenha(222333);
		// INSTANCIAR COMUNIDADE
		Comunidade[] comunidade = new Comunidade[2];
		comunidade[0] = new Comunidade();
		comunidade[1] = new Comunidade();
		// INSTANCIAR COMUNIDADE 1
		comunidade[0].setNome("Jaco Wolsterrof");
		comunidade[0].setCpf("11122233355599");
		comunidade[0].setIdComunidade(555444);
		comunidade[0].setSenha(122111);
		// COMUNIDADE 2 NAO FOI INSTANCIADO POIS SERA FEITO O CADASTRO NO ATO DA CHAMADA
		
		// QUANDO FOR SOLICITADO O VALOR TANTO PARA LOGIN OU SENHA OU CPF INSERIR CONFORME O SET 
		// VALORES QUE FORAM SETADOS FORAM CRIADOS ALEATORIO NÃO SENDO OFICIAIS
		do {
		System.out.printf(" GIOCONDA SISTEMA ACADEMICO UNIASSELVI  \n  \t AMBIENTE VIRTUAL  \n\n" );
		System.out.printf(" ACADEMICO = 1 \n ACADEMICO SALA VIRTUAL = 2 \n COLABORADOR = 3 \n EMPRESA = 4 \n COMUNIDADE = 5 \n\n");
		   valorInicio = teclado.nextInt();
		   
			 switch(valorInicio) {
				case 1:
					academico[0].fazerLogin();
					academico[1].fazerLogin();
					continuar = 1;
				break;	 
				case 2:
					System.out.printf("### VEJA COMO ACESSAR A SALA VIRTUAL ### \n\n");
					System.out.printf("### ACESSAR SALA VIRTUAL ### \n ### DOWNLOADS TEAMS ### \n\n");
					continuar = 2;
				break;
				case 3: 
					colaborador[0].fazerLogin();
					colaborador[1].fazerLogin();
					continuar = 3;
					break;					
					case 4:
						empresa[0].fazerLogin();
						empresa[1].fazerLogin();
						continuar = 4;
						break;
					case 5:
						comunidade[0].fazerLogin();
						comunidade[1].fazerLogin();
						continuar = 5;
						break;
						default:
							System.out.printf("VALOR INVALIDO DIGITE VALORES DE 1 A 5 \n\n");
							
						break;		
			 }// FIM DO SWITCH 
		} while ( continuar > 5);// FIM DO WHILE
	}
}// FIM CLASSE MAIN

