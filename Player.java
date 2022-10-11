/*
 * Player.java
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
import java.util.*;

public class Player {
	
	private String name;
	private ArrayList<Game> games;
	
	// Construtor
	public Player(String name) {
		this.name = name;
		games = new ArrayList<>();
	}
	
	// Altera o nome do jogador
	public void setName(String name) {
		this.name = name;
	}
	
	// Retorna o nome do jogador
	public String getName(){
		return name;
	}
	
	// Adiciona um jogo na lista de jogos dele
	public void addGame(Game game) {
		games.add(game);
	}
	
	// Retorna a lista de jogos desse jogador
	public ArrayList<Game> getGames() {
		return games;
	}
}

