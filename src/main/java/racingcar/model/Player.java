package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public List<String> getWinner() {
        int maxPosition = player.values()
                .stream().mapToInt(Integer::intValue).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (String nickname : player.keySet()) {
            if (isWinner(nickname, maxPosition)) {
                winners.add(nickname);
            }
        }
        return winners;
    }

    private boolean isWinner(String nickname, int maxPosition) {
        return player.get(nickname) == maxPosition;
    }

}
