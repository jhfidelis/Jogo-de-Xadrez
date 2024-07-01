package jogoDeTabuleiro;

/**
 * Classe criada para determinar uma posição no tabuleiro 
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Peca {

	// Atributos da classe Peca
	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	// Método construtor da classe
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	// Método get da classe
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}// fim da classe
