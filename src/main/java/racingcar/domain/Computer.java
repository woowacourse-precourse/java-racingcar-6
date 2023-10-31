package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private final static int MOVEMENT_FLAG = 4;
    public boolean judgeCarMovement(int random) {
        if (random >= 4) {
            return true;
        }
        return false;
    }

    public List<String> judgeWinner(Map<String, Integer> carList) {
        List<String> winnerList = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for (String name : carList.keySet()) {
            if (carList.get(name) > max) {
                max = carList.get(name);
            }
        }

        for (String name : carList.keySet()) {
            if (carList.get(name) == max) {
                winnerList.add(name);
            }
        }
        return winnerList;
    }
}
