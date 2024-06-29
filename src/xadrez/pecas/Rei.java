package xadrez.pecas;

import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Rei
 * @author Henrique Fidelis
 * @since Classe criada em 29/06/2024
 */

public class Rei extends PecaDeXadrez{

	// Método construtor da classe Rei
	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	// Método toString da classe
	@Override
	public String toString() {
		return "R";
	}

}// fim da classe
