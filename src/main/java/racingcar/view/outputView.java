package racingcar.view;

import racingcar.domain.racingCars;

import java.util.Map;

public class outputView {
    private static final String RELAY_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_RESULT_MESSAGE = "최종 우승자 : ";
    public static void racingCarRelay(racingCars racingCars) {
        Map<String, Integer> racingCarRelayResult = racingCars.getRacingCarRelayResult();
        racingCarRelayResult.forEach((racingCarName, forwardCount) -> System.out.println(racingCarName + " : " + "-".repeat(forwardCount)));
        System.out.println();
    }

    public static void printRelayResult() {
        System.out.println(RELAY_RESULT_MESSAGE);
    }

    public static void printWinners(String[] winners) {
        System.out.print(WINNER_RESULT_MESSAGE);
        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);
            if (i < winners.length - 1) System.out.print(", ");
        }
    }
}
