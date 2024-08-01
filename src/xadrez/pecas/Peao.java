package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Peao
 * @author Henrique Fidelis
 * @since Classe criada em 29/07/2024
 */

public class Peao extends PecaDeXadrez {
	
	private PartidaDeXadrez partidaXadrez;

	// Método construtor da classe Peao
	public Peao(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaXadrez) {
		super(tabuleiro, cor);
		this.partidaXadrez = partidaXadrez;
	}

	// Método sobrescrito para definir os movimentos do Peao
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
			
			// #MovimentoEspecial - En Passant (Branco)
			if (posicao.getLinha() == 3) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().checarPosicao(esquerda) &&
						checarPecaOponente(esquerda) &&
						getTabuleiro().retornarPeca(esquerda) == partidaXadrez.getVulnerabilidadeEnPassant()) {
					mat[esquerda.getLinha() - 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().checarPosicao(direita) &&
						checarPecaOponente(direita) &&
						getTabuleiro().retornarPeca(direita) == partidaXadrez.getVulnerabilidadeEnPassant()) {
					mat[direita.getLinha() - 1][direita.getColuna()] = true;
				}
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
			
			// #MovimentoEspecial - En Passant (Preto)
			if (posicao.getLinha() == 4) {
				Posicao esquerda = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				if (getTabuleiro().checarPosicao(esquerda) &&
						checarPecaOponente(esquerda) &&
						getTabuleiro().retornarPeca(esquerda) == partidaXadrez.getVulnerabilidadeEnPassant()) {
					mat[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
				}
				Posicao direita = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				if (getTabuleiro().checarPosicao(direita) &&
						checarPecaOponente(direita) &&
						getTabuleiro().retornarPeca(direita) == partidaXadrez.getVulnerabilidadeEnPassant()) {
					mat[direita.getLinha() + 1][direita.getColuna()] = true;
				}
			}
		}
		return mat;
	}

	// Método toString da classe
	@Override
	public String toString() {
		return "P";
	}

}// fim da classe
