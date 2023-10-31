package racingcar.services;

import java.util.List;
import java.util.Map;
import racingcar.constant.Constant;
import racingcar.validate.Validator;
import racingcar.validate.impls.WinnerDetectorValidator;

public class WinnerDetector {
    public static void printAllWinners(RaceGameState state) {
        List<String> winners = detect(state);
        Validator validator = new WinnerDetectorValidator();
        validator.validate(winners);
        String printWinnersString = String.join(", ", winners);
        System.out.println(Constant.FINAL_WINNER + printWinnersString);
    }

    private static List<String> detect(RaceGameState state) {
        int longestDistance = findLongestDistance(state);
        Map<String, Integer> stateOfEachCar = state.getStateOfEachCar();
        return state.getStateOfEachCar()
                .keySet()
                .stream()
                .filter(element -> isLongest(stateOfEachCar, element, longestDistance))
                .toList();
    }

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
