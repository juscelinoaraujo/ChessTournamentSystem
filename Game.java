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
	private int whiteResult, blackResult;
	
	public Game(Player white, Player black) {
		this.white = white;
		this.black = black;
	}

	public Player getWhite() {
		return white;
	}
	
	public Player getBlack() {
		return black;
	}
	
	public void setWhiteResult(int result) {
		whiteResult = result;	
	}
	
	public void setBlackResult(int result) {
		blackResult = result;	
	}
	
	public int getWhiteResult() {
		return whiteResult;
	}
	
	public int getBlackResult() {
		return blackResult;
	}
}

