package racingcar.view;

import racingcar.domain.racingCars;

import java.util.Map;

public class outputView {
    private static final String RELAY_RESULT_MESSAGE = "\n실행 결과";
    public static void racingCarRelay(racingCars racingCars) {
        Map<String, Integer> racingCarRelayResult = racingCars.getRacingCarRelayResult();
        racingCarRelayResult.forEach((racingCarName, forwardCount) -> System.out.println(racingCarName + " : " + "-".repeat(forwardCount)));
        System.out.println();
    }

    public static void printRelayResult() {
        System.out.println(RELAY_RESULT_MESSAGE);
    }
}
