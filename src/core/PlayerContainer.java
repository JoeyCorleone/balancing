package core;
import java.util.ArrayList;
import java.util.Iterator;


public class PlayerContainer implements Iterable<Player> {
	
	private static PlayerContainer unique = null;
	private ArrayList<Player> players;
	
	private PlayerContainer() {
		players = new ArrayList<>();
	}
	
	public static PlayerContainer instance() {
		if (unique == null)
			unique = new PlayerContainer();
		return unique;
	}
	
	public boolean addPlayer(Player player) {
		return players.add(player);
	}
	
	public boolean removePlayer(Player player) {
		return players.remove(player);
	}
	
	public Player getPlayer(int i) {
		if (i >= 0 && i < players.size())
			return players.get(i);
		else
			throw new IllegalArgumentException("Index out of bounds: " + i);
	}
	
	public int size() {
		return players.size();
	}

	@Override
	public Iterator<Player> iterator() {
		return players.iterator();
	}
	
}
