package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players = new ArrayList<>();

    public Players (List<String> names) {
        for (String name : names) {
            add(name);
        }
    }

    public void add(String name) {
        players.add(new Player(name));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
