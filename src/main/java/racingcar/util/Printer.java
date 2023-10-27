package racingcar.util;

import static racingcar.constant.Message.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Printer {
    public void printStartMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printRequestRoundMessage() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RACE_RESULT);
    }

    public void printRoundResult(Map.Entry<String, StringBuilder> scoreBoard) {
        System.out.println(scoreBoard.getKey() + " : " + scoreBoard.getValue());
    }

    public void printWinnersNames(List<String> winnerNames) {
        System.out.println(WINNER_NAME + String.join(DELIMITER, winnerNames));
    }
}
