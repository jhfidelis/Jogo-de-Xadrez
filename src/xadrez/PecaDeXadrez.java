package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Tabuleiro;

/**
 * Classe criada para determinar uma posição e uma cor a uma peça de xadrez
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */
public class PecaDeXadrez extends Peca {

	// Atributo da clase PecaDeXadrez
	private Cor cor;

	// Método construtor da classe
	public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	// Método get da classe
	public Cor getCor() {
		return cor;
	}

}// fim da classe
