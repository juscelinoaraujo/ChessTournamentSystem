/*
 * tournament.java
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

public class Tournament {
	
	private String name;
	private ArrayList<Performance> ranking;
	private ArrayList<Game>[] round;
	int numRounds; 
	
	// Construtor
	public Tournament(String name) {
		this.name = name;
		ranking = new ArrayList<>();
		numRounds = 0;
	}
	
	// Adiciona um jogador a um torneio
	public void addPlayer(Player player) {
		if (numRounds == 0) {
			ranking.add(new Performance(player));
		}
	}
	
	// Remove um jogador do torneio
	public void removePlayer(Player player) {
		for (Performance pf : ranking) {
			if (pf.getPlayer() == player) {
				ranking.remove(pf);
				break;
			}
		}
	}
	
	// Metodo auxiliar na construcao do torneio:
	// Faz o emparceiramento inicial
	private int[] initialPositions(int length) {
		int[] pos = new int[length];;
		pos[1] = 1;
		for (int i = 2; i<= length-2; i=i+2) {
			pos[i] = 1 + i;
			pos[i+1] = length - i;
		}
		pos[length] = length;
		return pos;
	} 
	
	// Metodo auxiliar na construcao do torneio
	// Muda o emparceiramento a cada rodada
	private int nextPosition(int pos, int length) {
		if (pos > 2) {
			return pos - 1;
		} else {
			return length;
		}
	}
	
	// Cria um torneio completo de todos contra todos
	public void newSchuringTournament() {
		ArrayList<Player> p = getPlayers();
		numRounds = p.size() - 1;
		Player aux = new Player("AUX");
		if (p.size() % 2 == 1) {
			p.add(aux);
		}
		Collections.shuffle(p);
		int[] pos = initialPositions(p.size());
		for (int i = 1; i <= p.size()-1; i++) {
			round[i] = new ArrayList<>();
			if (i % 2 == 1) {
				round[i].add(new Game(p.get(pos[1]), p.get(pos[p.size()])));
			} else {
				round[i].add(new Game(p.get(pos[p.size()]), p.get(pos[1])));
			}
			for (int j = 2; j<= p.size()-2; j=j+2) {
				if (i % 2 == 1) {
					round[i].add(new Game(p.get(pos[j]), p.get(pos[j+1])));
				} else {
					round[i].add(new Game(p.get(pos[j+1]), p.get(pos[j])));
				}
			}
			round[i].removeIf(g -> g.getWhite() == aux || g.getBlack() == aux);
			Collections.shuffle(round[i]);
			for (int j = 2; j<= p.size(); j++) {
				pos[j] = nextPosition(pos[j], p.size());
			}
		}
	}
	
	// Define os resultados de um jogo
	public void setGameResult(Game game, double whiteResult, double blackResult) {
		game.setResults(whiteResult, blackResult);
		for (Performance pf : ranking) {
			if (pf.getPlayer() == game.getWhite()) {
				pf.updatePerformance(whiteResult);
				break;
			}
		}
		for (Performance pf : ranking) {
			if (pf.getPlayer() == game.getBlack()) {
				pf.updatePerformance(blackResult);
				break;
			}
		}
	}
	
	// Atualiza o ranking
	public void updateRanking() {
		ranking.sort((pf1,pf2) -> Integer.compare(pf1.getPoints(), pf2.getPoints()));
	}
	
	// Retorna o nome do torneio
	public String getName() {
		return name;
	}
	
	// Retorna a lista dos jogadores do torneio
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> players = new ArrayList<>();
		for (Performance pf : ranking) {
			players.add(pf.getPlayer());
		}
		return players;
	}
	
	// Retorna a performance de um jogador
	public Performance getPerformance(Player player) {
		Performance perf = new Performance(new Player("Inexistente"));
		for (Performance pf : ranking) {
			if (pf.getPlayer() == player) {
				perf = pf;
			}
		}
		return perf;
	}
	
	// Retorna a posicao de um jogador na classificacao do torneio
	public int getPosition(Player player){
		int pos = 0;
		for (Performance pf : ranking) {
			if (pf.getPlayer() == player) {
				pos = ranking.indexOf(pf);
			}
		}
		return pos;
	}
	
	// Retorna o ranking completo do torneio
	public ArrayList<Performance> getRanking() {
		return ranking;
	}
	
	// Retorna a lista de jogos de uma rodada especifica
	public ArrayList<Game> getRound(int i) {
		return round[i];
	}
	
	// Retorna o numero de rodadas do torneio
	public int getNumRounds() {
		return numRounds;
	}
}

