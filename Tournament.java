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
	private ArrayList<Player> players;
	private HashMap<Player, Performance> ranking;
	private ArrayList<Game>[] round;
	int numRounds; 
	
	
	public Tournament(String name) {
		this.name = name;
		players = new ArrayList<>();
		ranking = new HashMap<Player, Performance>();
		numRounds = 0;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		ranking.put(player, new Performance());
	}
	
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
	
	private int nextPosition(int pos, int length) {
		if (pos > 2) {
			return pos - 1;
		} else {
			return length;
		}
	}
	
	public void newSchuringTournament() {
		ArrayList<Player> p = players;
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
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public HashMap<Player, Performance> getRanking() {
		return ranking;
	}
	
	public ArrayList<Game> getRound(int i) {
		return round[i];
	}
	
	public int getNumRounds() {
		return numRounds;
	}
}

