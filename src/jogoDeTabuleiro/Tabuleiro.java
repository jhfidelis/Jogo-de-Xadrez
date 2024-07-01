package jogoDeTabuleiro;

/**
 * Classe criada para representar um tabuleiro
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("ERRO NA CRIAÇÃO DO TABULEIRO: E necessário que haja pelo menos 1 linha e 1 coluna!");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}

	// Método para retornar uma peça usando como parâmetro uma linha e uma coluna
	public Peca retornarPeca(int linha,  int coluna) {
		if (!checarPosicao(linha, coluna)) {
			throw new TabuleiroException("Posição não está no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	// Sobrecarga do método retornarPeca passando uma Posição como parâmetro
	public Peca retornarPeca(Posicao posicao) {
		if (!checarPosicao(posicao)) {
			throw new TabuleiroException("Posição não está no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	// Método para inseir uma peça numa posição do tabuleiro
	public void inserirPeca(Peca peca, Posicao posicao) {
		if (checarPeca(posicao)) {
			throw new TabuleiroException("Existe uma peça nessa posição "+ posicao +"!");
		}
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

	// Métodos para checar se a posição existe no tabuleiro
	private boolean checarPosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean checarPosicao(Posicao posicao) {
		return checarPosicao(posicao.getLinha(), posicao.getColuna());
	}

	// Método para checar se existe uma peça na posição informada
	public boolean checarPeca(Posicao posicao) {
		if(!checarPosicao(posicao)) {
			throw new TabuleiroException("Posição não está no tabuleiro");
		}
		return retornarPeca(posicao) != null;
	}

}// fim da classe
