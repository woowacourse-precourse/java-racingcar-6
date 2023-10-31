package racingcar.services;

import java.util.Map;

public class WinnerDetector {

    private static boolean isLongest(Map<String, Integer> state, String target, int distance) {
        return state.get(target) == distance;
    }

    private static int findLongestDistance(RaceGameState state) {
        Map<String, Integer> stateOfEachCar = state.getStateOfEachCar();
        return stateOfEachCar
                .values()
                .stream()
                .reduce(Integer::max)
                .orElse(0);
    }

}
