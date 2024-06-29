package aplicacao;

import xadrez.PartidaDeXadrez;

/**
 * Classe principal do projeto
 * @author Henrique Fidelis
 * @since Classe criada em 25/06/2024
 */

public class Programa {

	public static void main(String[] args) {
		
		PartidaDeXadrez partida = new PartidaDeXadrez();
		UI.imprimirTabuleiro(partida.getPecas());

	}// fim do main

}// fim da classe
