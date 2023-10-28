package racingcar.model;

import java.util.HashMap;

public class Player {

    private final HashMap<String, Integer> player = new HashMap<>();

    public void register(String nickname) {
        player.put(nickname, 0);
    }

    public HashMap<String, Integer> getPlayer() {
        return player;
    }
}
