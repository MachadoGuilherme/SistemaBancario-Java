package sistemabancario;

import java.util.Scanner;

public class Cliente {
	private String nome;
	private char genero;
	private int nif;


	public Cliente() {

	}

	public void informacao() {
		System.out.println("Nome: " + nome + "\nGenero: " + genero + "\nNIF: " + nif);
	}

	public void pedirInformacao() {

		Scanner input = new Scanner(System.in);

		System.out.println("\nNome: ");
		nome = input.next().toUpperCase();

		System.out.println("\nGénero: ");
		genero = input.next().toUpperCase().charAt(0);

		System.out.println("\nNIF: ");
		nif = input.nextInt();

	}

	public void editarInformacao() {

		Scanner input = new Scanner(System.in);

		System.out.println("\nNome atual: " + nome + "\nNovo nome: ");
		nome = input.next().toUpperCase();

		/*System.out.println("\nGénero atual: " + genero + "\nNovo género: ");
		genero = input.next().toUpperCase().charAt(0);*/

		System.out.println("\nNIF atual: " + nif + "\nNovo NIF: ");
		nif = input.nextInt();

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getNif() {
		return nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}
}
