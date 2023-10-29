package racingcar.model;

import java.util.HashMap;

public class Player {

    private final HashMap<String, Integer> player = new HashMap<>();
    private Integer gameTime;

    public void registerNickname(String nickname) {
        player.put(nickname, 0);
    }

    public void registerGameTime(String inputGameTime) {
        gameTime = Integer.parseInt(inputGameTime);
    }

    public HashMap<String, Integer> getPlayer() {
        return player;
    }

    public Integer getGameTime() {
        return gameTime;
    }
}
