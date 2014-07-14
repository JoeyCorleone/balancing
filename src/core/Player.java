package core;


public class Player {
	
	private String name;
	private Team team;
	private double ratio;
	
	public Player(String name, double ratio) {
		this.name = name;
		team = Team.UNASSIGNED;
		this.ratio = ratio;
	}
	
	public String getName() {
		return name;
	}
	
	public double getRatio() {
		return ratio;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Team getTeam() {
		return team;
	}
	
	@Override
	public String toString() {
		return "Player: " + getName() + " [" + Math.round(getRatio()*100)/100.0 + "]";
	}
	
}
