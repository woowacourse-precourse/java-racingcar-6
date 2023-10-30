package racingcar.view;

import racingcar.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

public class OutputMessage {

    public static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";

    public static void printGameStatusMessage(String[] carPositions, int carsCount) {
        for (int i = 0; i < carsCount; i++) {
            System.out.println(carPositions[i]);
        }
        System.out.println();
    }

    public static void printWinnerMessage(List<String> winner) {
        String result = winner.stream()
                .collect(Collectors.joining(","));

        System.out.print(result);
    }
}
