package persistence;

import java.io.IOException;

import com.csvreader.CsvReader;

import core.Player;
import core.PlayerContainer;

public class PersistenceCSV implements IPersistence {

	private static final String FILENAME = "persistence/csv/stats.csv";
	private static final char DELIMITER = ';';
	
	private static final int COLUMN_NICK = 0;
	private static final int COLUMN_FULL_L_RATIO = 7;
	private static final int COLUMN_PARTICIPATING = 8;
	private static final String IS_PARTICIPATING = "x";

	@Override
	public void loadPlayers() throws PersistenceException {
		PlayerContainer pCon = PlayerContainer.instance();
		CsvReader csvReader = null;
		try {
			csvReader = new CsvReader(FILENAME, DELIMITER);
			csvReader.skipLine();
			csvReader.skipLine();
			csvReader.readHeaders();
			csvReader.readRecord(); // skip headers
			while (csvReader.readRecord()) {
				if (csvReader.get(COLUMN_PARTICIPATING).equals(IS_PARTICIPATING)) {
					String nick = csvReader.get(COLUMN_NICK);
					double ratio = Double.valueOf(csvReader.get(COLUMN_FULL_L_RATIO));
					Player player = new Player(nick, ratio);
					pCon.addPlayer(player);
				}
			}
		} catch (IOException | NumberFormatException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			if (csvReader != null)
				csvReader.close();
		}
	}

}
