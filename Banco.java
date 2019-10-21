package sistemabancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

	private String nome;
	ArrayList listaContas;
	ArrayList listaClientes;
	Conta contaAtiva;

	public Banco(String nome) {
		this.nome = nome;
		contaAtiva = null;
		listaContas = new ArrayList();
		listaClientes = new ArrayList();
	}

	public void executaMenu() {

		System.out.println("\tBem Vindo ao My Bank\n");

		Scanner input = new Scanner(System.in);

		int opcaoMenuInicial;
		int opcaoMenuContas;
		int opcaoMenuClientes;
		int opcaoMenuBanco;
//=================================================================================================================================		
		do {
			System.out.println("\n##-Menu Inicial-##\n");
			System.out.println("1 - Menu Contas");
			System.out.println("2 - Menu Clientes");
			System.out.println("3 - Menu Banco");
			System.out.println("0 - Sair\n");
			opcaoMenuInicial = input.nextInt();
			
			if(opcaoMenuInicial < 0 || opcaoMenuInicial > 3) {
				System.out.println("\n\tOpcao Invalida!\n");
				//break;
			}
			else {
				if(opcaoMenuInicial == 1) {
					do {
						System.out.println("\n\t*** Menu de Contas ***\n");
						System.out.println("0 - Voltar");
						System.out.println("1 - Criar conta Ordem");
						System.out.println("2 - Criar conta Jovem");
						System.out.println("3 - Criar conta Prazo");
						System.out.println("4 - Ver todas as contas");
						System.out.print("\nEscolha a Opção: ");
						opcaoMenuContas = input.nextInt();

						if(opcaoMenuContas < 0 || opcaoMenuContas > 4) {
							System.out.println("\n\tOpcao Invalida!\n");
							//break;
						}
						else {
							if(opcaoMenuContas == 1) {
								ContaOrdem co = new ContaOrdem();
								listaContas.add(co);
								System.out.println("\nConta Ordem criada com Sucesso!\nNumero da conta: " + co.getNumeroConta() + "\n");
								//break;
							}
							if(opcaoMenuContas == 2) {
								ContaJovem cj = new ContaJovem();
								listaContas.add(cj);
								System.out.println("\nConta Jovem criada com Sucesso!\nNumero da conta: " + cj.getNumeroConta() + "\n");
								//break;
							}
							if(opcaoMenuContas == 3) {
								ContaPrazo cp = new ContaPrazo();
								listaContas.add(cp);
								System.out.println("\nConta Prazo criada com Sucesso!\nNumero da conta: " + cp.getNumeroConta() + "\n");
								//break;
							}
							if(opcaoMenuContas == 4) {
								System.out.println("\n\t** Ver todas as contas **");
								for ( int i = 0 ; i < listaContas.size() ; i++ ) {
									Conta c = (Conta) listaContas.get(i);
									c.informacao();
								}
								//break;
							}
						}
					}while(opcaoMenuContas != 0);
				}//----------opcao numero 1 CONTAS termina aqui----------
				if(opcaoMenuInicial == 2) {
					do {
						System.out.println("\n\t*** Menu Clientes ***\n");
						System.out.println("0 - Voltar");
						System.out.println("1 - Inserir");
						System.out.println("2 - Editar");
						System.out.println("3 - Apagar");
						System.out.println("4 - Listar");
						System.out.println("5 - Escolher Conta Ativa");
						System.out.println("6 - Associar cliente a conta");

						if ( contaAtiva != null ) {
							System.out.println("7 - Depositar");
							System.out.println("8 - Levantar");
							System.out.println("9 - Saldo");
							System.out.println("10 - Transferir");
							System.out.println("\nConta ativa: " + contaAtiva.getNumeroConta());
						}
						System.out.print("\nEscolha a Opção: ");
						opcaoMenuClientes = input.nextInt();
						
						if(opcaoMenuClientes < 0 || opcaoMenuClientes > 10) {
							System.out.println("\n\tOpcao Invalida!\n");
							//break;
						}
						else {
							if(opcaoMenuClientes == 1) {
								inserirCliente();
								//break;
							}
							if(opcaoMenuClientes == 2) {
								editarCliente();
								//break;
							}
							if(opcaoMenuClientes == 3) {
								apagarCliente();
								//break;
							}
							if(opcaoMenuClientes == 4) {
								listarClientes();
								//break;
							}
							if(opcaoMenuClientes == 5) {
								escolherContaAtiva();
								//break;
							}
							if(opcaoMenuClientes == 6) {
								if ( contaAtiva != null ) {
									associarClienteConta();
								} else {
									System.out.println("\n\t >> Voce deve Ativar uma conta na Opção 5 do Menu Clientes antes! << \n");
								}
								//break;
							}
							if(opcaoMenuClientes == 7) {
								if ( contaAtiva != null ) {
									efetuarDeposito();
								}
								//break;
							}
							if(opcaoMenuClientes == 8) {
								if ( contaAtiva != null ) {
									efetuarLevantamento();
								}
								//break;
							}
							if(opcaoMenuClientes == 9) {
								if ( contaAtiva != null ) {
									verSaldo();
								}
								//break;
							}
							if(opcaoMenuClientes == 10) {
								if ( contaAtiva != null ) {
									transferirEntreContas();
								}
								//break;
							}
						}
					}while(opcaoMenuClientes != 0);
				}//----------opcao numero 2 CLIENTES termina aqui----------
				if(opcaoMenuInicial == 3) {
					do {
						System.out.println("0 - Voltar");
						System.out.println("1 - Total do dinheiro depositado no Banco");
						System.out.println("2 - Ver todas as contas");
						System.out.print("\nEscolha a Opção: ");
						opcaoMenuBanco = input.nextInt();

						if(opcaoMenuBanco < 0 || opcaoMenuBanco > 10) {
							System.out.println("\n\tOpcao Invalida!\n");
							//break;
						}
						else {
							if(opcaoMenuBanco == 1) {
								System.out.println("\n\tTotal de todas as contas\n");
								double total = 0;
								for ( int i = 0 ; i < listaContas.size() ; i++ ) {
									Conta c = (Conta) listaContas.get(i);
									total = total + c.getSaldo(); 
								}
								System.out.println("\nTOTAL DO BANCO: " + total);
								//break;
							}
							if(opcaoMenuBanco == 2) {
								System.out.println("\n\t** Ver todas as contas **");
								for ( int i = 0 ; i < listaContas.size() ; i++ ) {
									Conta c = (Conta) listaContas.get(i);
									c.informacao();
								}
								//break;
							}
						}
					}while(opcaoMenuBanco != 0);
				}//----------opcao numero 3 BANCO termina aqui---------
			}//menu das opcoes termina aqui (ELSE)
		}while(opcaoMenuInicial != 0);
		System.out.println("\n### Até a Proxima! ###\n");
//=================================================================================================================================
	}

	private void transferirEntreContas() {
		int n = inputInteiro("Digite o número de conta destino: ");
		Conta contaDestino = pesquisarConta(n);
		if ( contaDestino  == null ) {
			System.out.println("\nConta destino inexistente\n");
		} else {
			if ( contaAtiva.equals(contaDestino)) {
				System.out.println("\n!! A conta destino não pode ser a mesma !!\n");
			} else {
				contaAtiva.transferir(contaDestino);
				System.out.println(contaAtiva.getMensagemDaUltimaOperacao());
			}
		}
	}

	private void escolherContaAtiva() {
		int n = inputInteiro("Digite o número de conta: ");
		Conta c = pesquisarConta(n);
		if ( c  != null ) {
			contaAtiva = c;
		} else {
			System.out.println("\nConta inexistente\n");
		}
	}

	private void associarClienteConta() {

		int nif = inputInteiro("Digite o NIF do cliente: ");
		Cliente cli = pesquisarCliente(nif);

		if ( cli != null ) {
			contaAtiva.setCliente(cli);
		}
	}

	private void efetuarDeposito() {
		contaAtiva.efetuaDeposito();
	}
	private void efetuarLevantamento() {
		contaAtiva.efetuaLevantamento();
	}
	private void verSaldo() {
		contaAtiva.informacao();
	}

	private void inserirCliente() {

		Cliente novoCliente = new Cliente();
		novoCliente.pedirInformacao();

		adicionaCliente(novoCliente);
	}

	private void listarClientes() {

		System.out.println("\n\tListar clientes\n");
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente cli = (Cliente) listaClientes.get(i);
			cli.informacao();
		}
		System.out.println("\n");
	}

	private int inputInteiro(String mensagem) {

		Scanner input = new Scanner(System.in);
		System.out.println("\n" + mensagem);
		int inteiro = input.nextInt();
		return inteiro;

	}

	private void apagarCliente() {

		int n = inputInteiro("Digite o NIF pretendido:");
		//
		// 			### Apagar por refª ###
		//          Cliente cli = pesquisarCliente(n);
		//          if ( cli == null ) {
		//              System.out.println("\nNIF inexistente");
		//          } else {
		//              listaClientes.remove(cli);
		//              System.out.println("\nCliente apagado");
		//          }

		int indiceParaApagar = pesquisarClienteDevolvendoIndice(n);

		if ( indiceParaApagar == -1 ) {
			System.out.println("\nNIF inexistente!\n");
		} else {
			listaClientes.remove(indiceParaApagar);
			System.out.println("\nCliente apagado!\n");
		}

	}

	private void editarCliente() {    

		int n = inputInteiro("Digite o NIF: ");
		Cliente cli = pesquisarCliente(n);

		if ( cli != null ) {
			cli.editarInformacao();
		}
	}

	private Cliente pesquisarCliente(int nif) {

		Cliente cli = null;

		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = (Cliente) listaClientes.get(i);

			if ( c.getNif() == nif) {
				cli = c;
				break;
			}
		}
		return cli;

	}

	private int pesquisarClienteDevolvendoIndice(int nif) {

		int indice = -1;

		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente c = (Cliente) listaClientes.get(i);

			if ( c.getNif() == nif) {
				indice = i;
				break;
			}
		}
		return indice;

	}

	private Conta pesquisarConta(int numeroConta) {

		Conta conta = null;

		for (int i = 0; i < listaContas.size(); i++) {
			Conta c = (Conta) listaContas.get(i);

			if ( c.getNumeroConta() == numeroConta) {
				conta = c;
				break;
			}
		}
		return conta;

	}

	public void adicionaCliente(Cliente c) {
		listaClientes.add(c);
	}

	public void informacao() {
		System.out.println("\n" + nome);
		// estatisticas de contas e clientes

		if (listaContas.size() > 0) {
			System.out.println("Lista de contas");
			for (int i = 0; i < listaContas.size(); i++) {
				Conta c = (Conta) listaContas.get(i);
				c.informacao();
			}
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
