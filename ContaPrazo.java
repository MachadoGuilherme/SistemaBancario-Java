package sistemabancario;

public class ContaPrazo extends Conta {
	private double juro;

	public ContaPrazo() {
		super();
		juro = 1.05;
	}

	public boolean levantar(double valor) {
		setMensagemDaUltimaOperacao("\tAinda não pode realizar movimentos\n");
		return false;
	}

	public void efetuaLevantamento() {
		System.out.println("\tNão é possível realizar levantamentos\n");
	}

	public void transferir(Conta contaDestino) {
		super.transferir(contaDestino);
		System.out.println("\tNão é possível realizar transferencias\n");
	}


	public void efetuaDeposito() {
		depositar(lerValor("Valor para depositar: "));
	}



	public double getSaldo() {

		double s = super.getSaldo();
		s *= juro;
		return s;
	}

	public void informacao() {
		super.informacao();
		System.out.println("Saldo: " + getSaldo());

	}

	@Override
	public String toString() {
		return new String("\nConta Prazo");
	}
}
