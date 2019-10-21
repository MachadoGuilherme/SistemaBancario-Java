package sistemabancario;

import java.util.Scanner;

public abstract class Conta {

	private static int proximoNumero = 0;

	private int numeroConta;
	private double saldo;
	private Cliente cliente;
	private String mensagemDaUltimaOperacao;

	public Conta(){

		++proximoNumero;
		numeroConta =  proximoNumero;

		saldo = 0;
		cliente = null;
		mensagemDaUltimaOperacao =  "\tCriação de conta\n";
	}

	public void informacao() {
		System.out.print(toString() + "\nNumero de Conta: " + numeroConta + "\n");
		if ( cliente == null ) {
			System.out.print("\tSem cliente associado\n");
		} else {
			System.out.print("Cliente: " + cliente.getNome()+ "\n");
		}

	}

	public void transferir(Conta contaDestino) {
		setMensagemDaUltimaOperacao("\tTransferencia\n");
	}

	@Override
	public String toString() {
		return new String("Conta\n");
	}

	public void depositar(double valor) {
		saldo+=valor;
	}

	public boolean levantar(double valor) {
		saldo-=valor;
		setMensagemDaUltimaOperacao("\tLevantamento efetuado!\n");
		return true;
	}

	public double lerValor(String mensagem) {
		Scanner input = new Scanner(System.in);

		System.out.println(mensagem);
		double v = input.nextDouble();
		return v;
	}

	public void efetuaLevantamento() {

	}

	public void efetuaDeposito() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getMensagemDaUltimaOperacao() {
		return mensagemDaUltimaOperacao;
	}

	public void setMensagemDaUltimaOperacao(String mensagemDaUltimaOperacao) {
		this.mensagemDaUltimaOperacao = mensagemDaUltimaOperacao;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

}
