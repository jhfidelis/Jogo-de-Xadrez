package xadrez;

import jogoDeTabuleiro.Peca;
import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;

/**
 * Classe criada para determinar uma posição e uma cor a uma peça de xadrez
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */
public abstract class PecaDeXadrez extends Peca {

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

	// Método get para retornar uma posição do xadrez
	public PosicaoDoXadrez getPoisicaoDoXadrez() {
		return PosicaoDoXadrez.converterParaPosicaoDoXadrez(posicao);
	}

	// Método para checar se há uma peça oponente como opção para a peça selecionada
	protected boolean checarPecaOponente (Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().retornarPeca(posicao);
		return p != null && p.getCor() != cor;
	}

}// fim da classe
