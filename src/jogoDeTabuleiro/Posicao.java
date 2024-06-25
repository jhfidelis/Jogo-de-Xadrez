package jogoDeTabuleiro;

/**
 * Classe criada para indicar uma posição no tabuleiro
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Posicao {

	// Atributos da classe Posicao
	private int linha;
	private int coluna;

	// Método construtor da classe Posicao
	public Posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	// Métodos getters e setters
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	// Método toString para imprimir a linha e coluna
	@Override
	public String toString() {
		return linha + ", " + coluna;
	}

}// fim da classe
