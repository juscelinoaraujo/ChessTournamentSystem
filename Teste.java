package chessTournamentSystem;

public class Teste {
	public static void main(String[] args) {
		Player juscelino = new Player("Juscelino");
		Player mateus = new Player("Mateus");
		Player alvaro = new Player("Álvaro");
		Player cicero = new Player("Cícero");
		Player joao = new Player("João");
		Player eduardo = new Player("Eduardo");
		Tournament torneio = new Tournament("Falcão League");
		torneio.addPlayer(joao);
		torneio.addPlayer(cicero);
		torneio.addPlayer(alvaro);
		torneio.addPlayer(mateus);
		torneio.addPlayer(juscelino);
		torneio.addPlayer(eduardo);
		
		for (Player p : torneio.getPlayers()) {
			//System.out.println(p.getName());
			String str = p.getName()+": pontos="+torneio.getPerformance(p).getPoints()+
					     " vitórias="+torneio.getPerformance(p).getNumWins()+
					     " empates="+torneio.getPerformance(p).getNumDraws()+
					     " Derrotas="+torneio.getPerformance(p).getNumLosses();
			System.out.println(str);
		}
		torneio.newSchuringTournament();
		
		for (int i = 0; i<= torneio.getNumRounds()-1; i++) {
			//System.out.println(p.getName());
			System.out.println("Rodada "+(i+1));
			String str;
			for (Game g : torneio.getRound(i)) {
				str = g.getWhite().getName()+" x "+g.getBlack().getName();
				System.out.println(str);
				if (torneio.getRound(i).indexOf(g) == 0) {
					torneio.setGameResult(g, 2, 0);
				} else if (torneio.getRound(i).indexOf(g) == 1) {
					torneio.setGameResult(g, 0, 2);
				} else {
					torneio.setGameResult(g, 1, 1);
				}
			}
		}
		for (Player p : torneio.getPlayers()) {
			//System.out.println(p.getName());
			String str = p.getName()+": pontos="+torneio.getPerformance(p).getPoints()+
					     " vitórias="+torneio.getPerformance(p).getNumWins()+
					     " empates="+torneio.getPerformance(p).getNumDraws()+
					     " Derrotas="+torneio.getPerformance(p).getNumLosses();
			System.out.println(str);
		}
		torneio.updateRanking();
		for (Player p : torneio.getPlayers()) {
			//System.out.println(p.getName());
			String str = p.getName()+": pontos="+torneio.getPerformance(p).getPoints()+
					     " vitórias="+torneio.getPerformance(p).getNumWins()+
					     " empates="+torneio.getPerformance(p).getNumDraws()+
					     " Derrotas="+torneio.getPerformance(p).getNumLosses();
			System.out.println(str);
		}
		
		for (int i = 0; i<= torneio.getNumRounds()-1; i++) {
			//System.out.println(p.getName());
			System.out.println("Rodada "+(i+1));
			String str;
			for (Game g : torneio.getRound(i)) {
				str = g.getWhite().getName()+" "+g.getWhiteResult()+" x "+g.getBlackResult()+" "+g.getBlack().getName();
				System.out.println(str);
			}
		}
		System.out.println(torneio.getPosition(eduardo));
		Player p = juscelino;
		String str = p.getName()+": pontos="+torneio.getPerformance(p).getPoints()+
			     " vitórias="+torneio.getPerformance(p).getNumWins()+
			     " empates="+torneio.getPerformance(p).getNumDraws()+
			     " Derrotas="+torneio.getPerformance(p).getNumLosses();
		System.out.println(str);
	}
}
