package chessTournamentSystem;

public class Performance {
	
	private Player player;
	private int points, numWins, numDraws, numLosses;
	
	// Construtor
	public Performance(Player player) {
		this.player = player;
		points = 0;
		numWins = 0;
		numDraws = 0;
		numLosses = 0;
	}
	
	// Atualiza a performance de um jogador
	public void updatePerformance(int points) {
		this.points += points;
		if (points == 2) {
			numWins += 1;
		} else if (points == 1) {
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
	public int getPoints() {
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

}