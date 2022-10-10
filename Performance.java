/*
 * Performance.java
 * 
 * Copyright 2022 Carol <Carol@DESKTOP-8TUUFVA>
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


public class Performance {
	
	private Player player;
	private double points;
	private int numWins, numDraws, numLosses;
	
	public Performance(Player player) {
		this.player = new Player(player.getName());
		points = 0;
		numWins = 0;
		numDraws = 0;
		numLosses = 0;
	}
	
	public updatePerformance(double points) {
		this.points += points;
		if points == 1.0 then
			numWins += 1;
		else if points == 0.5 then
			numDraws += 1;
		else
			numLosses += 1;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public double getPoints() {
		return points;
	}
	
	public int getNumWins() {
		return numWins;
	}
	
	public int getNumDraws() {
		return numDraws;
	}
	
	public int getNumLosses() {
		return numLosses;
	}
}

