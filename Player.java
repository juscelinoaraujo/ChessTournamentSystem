package chessTournamentSystem;

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
