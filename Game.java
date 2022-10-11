/*
 * Game.java
 * 
 * Copyright 2022 temporario <temporario@mestrado-05>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


public class Game {
	
	private Player white, black;
	private double whiteResult, blackResult;
	
	// Construtor
	public Game(Player white, Player black) {
		this.white = white;
		this.black = black;
	}

	// Retorna o jogador de Brancas
	public Player getWhite() {
		return white;
	}
	
	// Retorna o jogador de Pretas
	public Player getBlack() {
		return black;
	}
	
	// Adiciona os resultados de um jogo
	// e adiciona esse jogo as listas de jogos de ambos os jogadores
	public void setResults(double whiteResult, double blackResult) {
		this.whiteResult = whiteResult;
		this.blackResult = blackResult;
		white.addGame(this);
		black.addGame(this);	
	}
	
	// Retorna o resultado das brancas
	public double getWhiteResult() {
		return whiteResult;
	}
	
	// Retorna o resultado das pretas
	public double getBlackResult() {
		return blackResult;
	}
}

