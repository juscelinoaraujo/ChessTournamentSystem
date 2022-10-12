package chessTournamentSystem;

public class Game {
	
	private Player white, black;
	private int whiteResult, blackResult;
	
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
	public void setResults(int whiteResult, int blackResult) {
		this.whiteResult = whiteResult;
		this.blackResult = blackResult;
		white.addGame(this);
		black.addGame(this);	
	}
	
	// Retorna o resultado das brancas
	public int getWhiteResult() {
		return whiteResult;
	}
	
	// Retorna o resultado das pretas
	public int getBlackResult() {
		return blackResult;
	}
}
