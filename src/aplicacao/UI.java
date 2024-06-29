package aplicacao;

import xadrez.PecaDeXadrez;

/**
 * 
 * @author Henrique Fidelis
 * @since Classe criada em 28/06/2024
 */

public class UI {

	public static  void imprimirTabuleiro(PecaDeXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j]);
			}
			System.out.println();
		}
		System.out.println("  A B C D E F G H");
	}

	private static void imprimirPeca(PecaDeXadrez peca) {
		if(peca == null) {
			System.out.print("-");
		}
		else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}

}// fim da classe
