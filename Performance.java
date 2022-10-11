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
import java.util.*;

public class Performance implements Comparator {
	
	private Player player;
	private double points;
	private int numWins, numDraws, numLosses;
	
	// Construtor
	public Performance(Player player) {
		this.player = player;
		points = 0;
		numWins = 0;
		numDraws = 0;
		numLosses = 0;
	}
	
	// Atualiza a performance de um jogador
	public void updatePerformance(double points) {
		this.points += points;
		if (points == 1.0) {
			numWins += 1;
		} else if (points == 0.5) {
			numDraws += 1;
		} else {
			numLosses += 1;
		}
	}
	
	// Retorna o jogador
	public Player getPlayer() {
		return player;
	}
	
	// Retorna o numero de pontos
	public double getPoints() {
		return points;
	}
	
	// Retorna o numero de vitorias
	public int getNumWins() {
		return numWins;
	}
	
	// Retorna o numero de empates
	public int getNumDraws() {
		return numDraws;
	}
	
	// Retorna o numero de derrotas
	public int getNumLosses() {
		return numLosses;
	}
	
	@Override
	public int compare(Performance pf1, Performance pf2) {

		int pointsCompare = pf1.getPoints().compareTo(pf2.getPoints());
		int winsCompare = pf1.getNumWins().compareTo(pf2.getNumWins());

		if (pointsCompare != 0) {
			return pointsCompare;
		} else {
			return winsCompare;
		}
	}
}

