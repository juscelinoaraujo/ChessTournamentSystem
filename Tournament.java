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
	private ArrayList<Performance> ranking;
	private Round[] rounds;
	int numRounds; 
	
	
	public Tournament(String name) {
		this.name = name;
		players = new ArrayList<>;
		ranking = new ArrayList<>;
		numRounds = 0;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		ranking.add(new Performance(player));
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
		ranking.removeIf(pfmce -> pfmce.getPlayer() == player);
	}
	
	public void updateRanking(Round round) {
		
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public ArrayList<Performance> getRanking() {
		return ranking;
	}
	
	public Round getRound(int i) {
		return rounds[i];
	}
	
	public Round[] getAllRounds() {
		return rounds;
	}
	
	public int getNumRounds() {
		return numRounds;
	}
}

