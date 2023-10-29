package racingcar.model;

import static racingcar.util.constant.GameRule.END_INCLUSIVE;
import static racingcar.util.constant.GameRule.MOVING_FORWARD_CONDITION;
import static racingcar.util.constant.GameRule.START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class RacingGame {

    public void start(HashMap<String, Integer> players) {
        movePlayers(players);
    }

    private void movePlayers(HashMap<String, Integer> players) {
        for (String player : players.keySet()) {
            moveConditionCheck(players, player);
        }
    }

    private void moveConditionCheck(HashMap<String, Integer> players, String player) {
        int myNumber = getRandomNumber();
        if (myNumber >= MOVING_FORWARD_CONDITION.getValue()) {
            int currentPosition = players.get(player);
            players.put(player, currentPosition + 1);
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue());
    }

}
