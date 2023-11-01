package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingReferee {

    private static final int THRESHOLD = 4;
    private final Players players;
    private final Map<Player, Integer> result;
    private final Dice dice;

    public RacingReferee(Players players, Dice dice) {
        result = new LinkedHashMap<>();
        initResult(players);
        this.players = players;
        this.dice = dice;
    }

    private void initResult(Players players) {
        for (Player player : players.getPlayers()) {
            result.put(player, 0);
        }
    }

    public Map<Player, Integer> playerMove() {
        List<Player> playerList = players.getPlayers();
        for (Player player : playerList) {
            int v = dice.roll();
            if (isMove(v)) {
                result.put(player, result.get(player) + 1);
            }
        }
        return result;
    }

    public List<String> getWinner() {
        int maxMove = Collections.max(result.values());

        List<String> winner = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            if (result.getOrDefault(player, 0) == maxMove) {
                winner.add(player.getName());
            }
        }

        return winner;
    }

    private boolean isMove(int value) {
        return value >= THRESHOLD;
    }
}