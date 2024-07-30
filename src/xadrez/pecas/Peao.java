package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public boolean[][] definirMovimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

		Posicao aux = new Posicao(0, 0);
		
		if (getCor() == Cor.BRANCO) {
			aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao aux2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux) && getTabuleiro().checarPosicao(aux2) && !getTabuleiro().checarPeca(aux2) && getContagemDeMovimento() == 0) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
		}
		else {
			aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao aux2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().checarPosicao(aux) && !getTabuleiro().checarPeca(aux) && getTabuleiro().checarPosicao(aux2) && !getTabuleiro().checarPeca(aux2) && getContagemDeMovimento() == 0) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
			
			aux.inserirValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().checarPosicao(aux) && checarPecaOponente(aux)) {
				mat[aux.getLinha()][aux.getColuna()] = true;
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
