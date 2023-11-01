package racingcar.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SavaPlayersData {
    PlayerRepository playerRepository = new PlayerRepository();
    public Map<String, Integer> savePlayers(List<String> players) {
        Map<String, Integer> savePlayer = new LinkedHashMap<>();
        for (String playerName : players) {
            Player gamePlayer = new Player(playerName, 0);
            playerRepository.save(gamePlayer);
            savePlayer.put(playerName, gamePlayer.getScore());
        }
        return savePlayer;
    }
}
