package xadrez.pecas;

import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Torre
 * @author Henrique Fidelis
 * @since Classe criada em 29/06/2024
 */

public class Torre extends PecaDeXadrez {

	// Método construtor da classe Torre
	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	// Método toString da classe
	@Override
	public String toString() {
		return "T";
	}

}// fim da classe
