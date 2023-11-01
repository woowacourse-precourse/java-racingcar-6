package racingcar.repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerRepository {

    private Map<String, Integer> store = new LinkedHashMap<>();

    public Player save(Player player) {
        store.put(player.getPlayerName(), player.getScore());
        return player;
    }

    public Map<String, Integer> getPlayers() {
        return store;
    }
}
