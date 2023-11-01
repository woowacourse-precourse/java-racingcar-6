package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a game and contains information of the current state of the game.
 */
public class GameManager {
    private final Map<String, Integer> cars;

    /**
     * Constructs an GameManager object in the initial state.
     * @param carNames an array which contains all the names of the cars to participate in.
     */
    public GameManager(String[] carNames) {
        this.cars = new HashMap<>();
        for (String car : carNames) {
            this.cars.put(car, 0);
        }
    }

    /**
     * Updates the state of a car. The car goes forward one step.
     * @param car the name of the car to proceed.
     */
    public void proceed(String car) {
        int previousState = this.cars.get(car);
        this.cars.put(car, previousState + 1);
    }

    /**
     * Returns the state of all the cars.
     * @return a map with (key, value) = (name of car, current state).
     *      The Map object is a copy of the member of GameManager, and it's unmodifiable.
     */
    public Map<String, Integer> getCurrentCarStates() {
        return Map.copyOf(this.cars);
    }

    /**
     * Returns a list containing names of cars which have proceeded the most.
     * If there are multiple winners, returns them all.
     * @return a list containing winners.
     */
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

    /**
     * Determines whether the car succeeded to proceed in random.
     * @return true if succeeded, otherwise false.
     */
    public static boolean isSuccessToProceed() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
