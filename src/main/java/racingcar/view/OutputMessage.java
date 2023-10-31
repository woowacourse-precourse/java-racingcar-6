package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputMessage {

    public static final String OUTPUT_WINNER_MESSAGE = "최종 우승자 : ";

    public static String printGameStatusMessage(String[] carPositions, int carsCount) {
        StringBuilder gameStatusMessage = new StringBuilder();
        for (int i = 0; i < carsCount; i++) {
            gameStatusMessage.append(carPositions[i]).append("\n");
        }
        gameStatusMessage.append("\n");
        return gameStatusMessage.toString();
    }

    public static String printWinnerMessage(List<String> winner) {

        String winnerMessage = winner.stream()
                .collect(Collectors.joining(","));

        return winnerMessage;

    }
}
