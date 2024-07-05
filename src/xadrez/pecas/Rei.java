package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
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

	// Método para checar se o rei pode se mexer para uma determinada posição
	private boolean checarMovimentoPossivel(Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().retornarPeca(posicao);
		return p == null || p.getCor() != getCor();
	}

	// Método sobrescrito para definir os movimentos do Rei
	@Override
	public boolean[][] definirMovimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao aux = new Posicao(0, 0);

		// Casas acima da peça
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna());
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas abaixo da peça
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna());
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas à esquerda da peça
		aux.inserirValores(posicao.getLinha(), posicao.getColuna() - 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas à direita da peça
		aux.inserirValores(posicao.getLinha(), posicao.getColuna() + 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		// Casas à noroeste da peça
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas à nordeste da peça
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas à sudoeste da peça
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		// Casas à sudeste da peça
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		return mat;
	}

}// fim da classe
