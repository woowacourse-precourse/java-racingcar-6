package racingcar.util;

import static racingcar.constant.Constant.*;

import java.util.List;
import java.util.Map;
import racingcar.game.ScoreBoard;

public class Printer {
    public void printStartMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printRequestRoundMessage() {
        System.out.println(INPUT_ROUND_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }

    public void printRoundResult(ScoreBoard scoreBoard) {
        for (Map.Entry<String, StringBuilder> pair : scoreBoard.getScoreBoard().entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        System.out.println();
    }

    public void printWinnersNames(List<String> winnerNames) {
        System.out.println(WINNER_NAME_MESSAGE + String.join(DELIMITER + " ", winnerNames));
    }
}
