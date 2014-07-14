package balancers;
import java.util.ArrayList;

import core.Player;
import core.PlayerContainer;
import core.Team;


public class SerpentineTwist implements IBalancer {

	private PlayerContainer pCon = PlayerContainer.instance();
	
	private ArrayList<Player> team1 = new ArrayList<>();
	private ArrayList<Player> team2 = new ArrayList<>();
	
	private ArrayList<Player> optTeam1;
	private ArrayList<Player> optTeam2;
	
	private double optTotalScoreTeam1;
	private double optTotalScoreTeam2;
	
	private double optTotalScoreDiff = Double.POSITIVE_INFINITY;
	
	@Override
	public void balance() {
		if (pCon.size() % 2 == 1) {
			throw new IllegalArgumentException("ERROR: Serpentine Twist requires an even amount of participants!");
		} else {
			serpentine();
			twist(-1);
			updateTeams();
		}
	}
	
	private void serpentine() {
		for (int i = 0; i < pCon.size(); i++) {
			Player pLowest = findPlayerWithLowestRatio();
			if (i % 2 == 1) {
				pLowest.setTeam(Team.ONE);
				team1.add(pLowest);
			}
			else {
				pLowest.setTeam(Team.TWO);
				team2.add(pLowest);
			}
		}
	}
	
	private void twist(int level) {
		if (level < team1.size() - 1) {
			twist(++level);
			switchPlayers(level);
			twist(level);
		} else {
			updateOptDiff();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void updateOptDiff() {
		double totalScoreTeam1 = calcTotalScore(team1);
		double totalScoreTeam2 = calcTotalScore(team2);
		double totalScoreDiff = Math.abs(totalScoreTeam1 - totalScoreTeam2);
		if (totalScoreDiff < optTotalScoreDiff) {
			optTotalScoreDiff = totalScoreDiff;
			optTotalScoreTeam1 = totalScoreTeam1;
			optTotalScoreTeam2 = totalScoreTeam2;
			optTeam1 = (ArrayList<Player>) team1.clone();
			optTeam2 = (ArrayList<Player>) team2.clone();
		}
	}
	
	private Player findPlayerWithLowestRatio() {
		Player pLowest = new Player("Dummy", Double.POSITIVE_INFINITY);
		for (int i = 0; i < pCon.size(); i++) {
			Player p = pCon.getPlayer(i);
			if (!p.getTeam().equals(Team.UNASSIGNED))
				continue;
			else if (pLowest.getRatio() > p.getRatio())
				pLowest = p;
		}
		return pLowest;
	}
	
	private void switchPlayers(int level) {
		team1.add(level, team2.get(level));
		Player p = team1.remove(level + 1);
		p.setTeam(Team.TWO);
		team2.add(level, p);
		team2.remove(level + 1).setTeam(Team.ONE);
	}
	
	private double calcTotalScore(ArrayList<Player> team) {
		double totalScore = 0;
		for (Player p : team)
			totalScore += p.getRatio();
		return totalScore;
	}
	
	private void updateTeams() {
		for (Player p : pCon) {
			for (Player q : optTeam1)
				if (p.getName().equals(q.getName()))
					p.setTeam(q.getTeam());
			for (Player q : optTeam2)
				if (p.getName().equals(q.getName()))
					p.setTeam(q.getTeam());
		}
	}

	@Override
	public void printResult() {
		System.out.println("----------------------");
		System.out.println("---SERPENTINE TWIST---");
		System.out.println("----------------------");
		System.out.println("\nINPUT:");
		System.out.println("------");
		for (Player p : pCon)
			System.out.println(p);
		System.out.println("\nRESULT:");
		System.out.println("-------");
		System.out.println("\nTEAM 1");
		System.out.println("------");
		for (Player p : optTeam1)
			System.out.println(p);
		System.out.println("\nTEAM 2");
		System.out.println("-------");
		for (Player p : optTeam2)
			System.out.println(p);
		System.out.println("\nVALUES");
		System.out.println("-------");
		System.out.printf("Total Score Team 1: %.2f", optTotalScoreTeam1);
		System.out.printf("\nTotal Score Team 2: %.2f", optTotalScoreTeam2);
		System.out.printf("\nDifference: %.2f", optTotalScoreDiff);
	}
	
}
