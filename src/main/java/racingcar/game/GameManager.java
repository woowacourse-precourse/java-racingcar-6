package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    private final Map<String, Integer> cars;

    public GameManager(String[] carNames) {
        this.cars = new HashMap<>();
        for (String car : carNames) {
            this.cars.put(car, 0);
        }
    }

    public void proceed(String car) {
        int previousState = this.cars.get(car);
        this.cars.put(car, previousState + 1);
    }

    public Map<String, Integer> getCurrentCarStates() {
        return Map.copyOf(this.cars);
    }

    public List<String> getWinners() {
        int max = 0;
        for (int state : cars.values()) {
            max = getMax(max, state);
        }

        List<String> winners = new ArrayList<>();
        for (String car : cars.keySet()) {
            addWinner(max, winners, car);
        }
        return winners;
    }

    private int getMax(int max, int state) {
        if (state > max) {
            max = state;
        }
        return max;
    }

    private void addWinner(int max, List<String> winners, String car) {
        if (cars.get(car) == max) {
            winners.add(car);
        }
    }

    public static boolean isSuccessToProceed() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
