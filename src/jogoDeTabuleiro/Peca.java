package jogoDeTabuleiro;

/**
 * Classe criada para determinar uma posição no tabuleiro 
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;

	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}// fim da classe
