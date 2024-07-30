package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Cavalo
 * @author Henrique Fidelis
 * @since Classe criada em 30/07/2024
 */

public class Cavalo extends PecaDeXadrez{

	// Método construtor da classe Cavalo
	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	// Método toString da classe
	@Override
	public String toString() {
		return "C";
	}

	// Método para checar se o cavalo pode se mexer para uma determinada posição
	private boolean checarMovimentoPossivel(Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().retornarPeca(posicao);
		return p == null || p.getCor() != getCor();
	}

	// Método sobrescrito para definir os movimentos do Cavalo
	@Override
	public boolean[][] definirMovimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao aux = new Posicao(0, 0);

		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() - 2);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() - 2, posicao.getColuna() - 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() - 2, posicao.getColuna() + 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() + 2);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() + 2);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() + 2, posicao.getColuna() + 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() + 2, posicao.getColuna() - 1);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}
		
		aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() - 2);
		if (getTabuleiro().checarPosicao(aux) && checarMovimentoPossivel(aux)) {
			mat[aux.getLinha()][aux.getColuna()] = true;
		}

		return mat;
	}

}// fim da classe
