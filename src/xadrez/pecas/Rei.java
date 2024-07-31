package xadrez.pecas;

import jogoDeTabuleiro.Posicao;
import jogoDeTabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

/**
 * Classe criada para representar a peça Rei
 * @author Henrique Fidelis
 * @since Classe criada em 29/06/2024
 */

public class Rei extends PecaDeXadrez{
	
	private PartidaDeXadrez partidaXadrez;

	// Método construtor da classe Rei
	public Rei(Tabuleiro tabuleiro, Cor cor, PartidaDeXadrez partidaXadrez) {
		super(tabuleiro, cor);
		this.partidaXadrez = partidaXadrez;
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

	// Método para testar a condição de Roque
	private boolean testarTorreParaRoque(Posicao posicao) {
		PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().retornarPeca(posicao);
		return p != null && p instanceof Torre && p.getCor() == getCor() && p.getContagemDeMovimento() == 0;
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
		
		// #MovimentoEspecial - Roque
		if (getContagemDeMovimento() == 0 && !partidaXadrez.getXeque()) {
			// #MovimentoEspecial - Roque pequeno
			Posicao posT1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 3);
			if (testarTorreParaRoque(posT1)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() + 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() + 2);
				if (getTabuleiro().retornarPeca(p1) == null && getTabuleiro().retornarPeca(p2) == null) {
					mat[posicao.getLinha()][posicao.getColuna() + 2] = true;
				}
			}
			
			// #MovimentoEspecial - Roque grande
			Posicao posT2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 4);
			if (testarTorreParaRoque(posT2)) {
				Posicao p1 = new Posicao(posicao.getLinha(), posicao.getColuna() - 1);
				Posicao p2 = new Posicao(posicao.getLinha(), posicao.getColuna() - 2);
				Posicao p3 = new Posicao(posicao.getLinha(), posicao.getColuna() - 3);
				if (getTabuleiro().retornarPeca(p1) == null && getTabuleiro().retornarPeca(p2) == null && getTabuleiro().retornarPeca(p3) == null) {
					mat[posicao.getLinha()][posicao.getColuna() - 2] = true;
				}
			}
		}

		return mat;
	}

}// fim da classe
