package sistemabancario;

public class ContaJovem extends ContaOrdem {
	private int limiteLevantamento;

	public ContaJovem() {
		super();
		limiteLevantamento = 20;
	}

	public void efetuaLevantamento() {
		boolean resposta = levantar(lerValor("Valor para levantar: "));
		if ( resposta == false ) {
			System.out.println(getMensagemDaUltimaOperacao());
		}

	}

	public boolean levantar(double valor) {
		boolean estado = false;

		if (valor <= limiteLevantamento) {
			estado = super.levantar(valor);
		}
		else {
			setMensagemDaUltimaOperacao("O seu limite de levantamento é: " + limiteLevantamento + "\n");
		}
		return estado;
	}

	@Override
	public String toString() {
		return new String("\nConta Jovem");
	}

}
