package sistemabancario;

public class ContaOrdem extends Conta {

	public ContaOrdem() {
		super();// chama explicitamente o construtor de Conta
		// depois adiciono comportamento de inicialização
	}

	public void transferir(Conta contaDestino) {
		super.transferir(contaDestino);
		double v = lerValor("Valor para transferir: ");

		if ( levantar(v) == true ) {
			contaDestino.depositar(v);
		}

	}

	public void efetuaLevantamento() {
		levantar(lerValor("Valor para levantar: "));

	}

	public void efetuaDeposito() {
		depositar(lerValor("Valor para depositar: "));
	}

	public boolean levantar(double valor) {

		boolean conseguiuLevantar = true;

		if (valor <= getSaldo()) {
			super.levantar(valor);            
		}
		else {
			conseguiuLevantar = false;
			setMensagemDaUltimaOperacao("\tNão tem saldo suficiente!!\n");
		}
		return conseguiuLevantar;
	}

	public void informacao() {
		super.informacao();
		System.out.println("Saldo: " + getSaldo());

	}

	@Override
	public String toString() {
		return new String("\nConta Ordem");
	}
}
