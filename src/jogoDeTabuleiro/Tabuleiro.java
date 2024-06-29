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
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	// Método para retornar uma peça usando como parâmetro uma linha e uma coluna
	public Peca retornarPeca(int linha,  int coluna) {
		return pecas[linha][coluna];
	}
	
	// Sobrecarga do método retornarPeca passando uma Posição como parâmetro
	public Peca retornarPeca(Posicao posicao) {
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}

	// Método para inseir uma peça numa posição do tabuleiro
	public void inserirPeca(Peca peca, Posicao posicao) {
		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}

}// fim da classe
