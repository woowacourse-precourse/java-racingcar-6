package racingcar.view;

import static racingcar.config.GameMessage.ATTEMPT_COUNT_INPUT_MESSAGE;
import static racingcar.config.GameMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.config.GameMessage.EACH_ROUND_DELIM;
import static racingcar.config.GameMessage.GAME_RESULT_MESSAGE;
import static racingcar.config.GameMessage.ONE_MOVE_DISTANCE;
import static racingcar.config.GameMessage.ROUND_RESULT_FORM;
import static racingcar.config.GameMessage.WINNER_MESSAGE_PREFIX;
import static racingcar.config.RacingConfig.CARS_JOIN_DELIM;

import java.util.List;

public class OutputView {
    public static void printCarNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE.getMessage());
    }

    public static void printAttemptCountInputMessage() {
        System.out.println(ATTEMPT_COUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE.getMessage());
    }

    public static void printRoundResult(String carName, int moveLength) {
        String form = ROUND_RESULT_FORM.getMessage();
        String distance = ONE_MOVE_DISTANCE.getMessage();

        System.out.printf(form, carName, distance.repeat(moveLength));
    }
    public static void printEachRoundSeparator() {
        System.out.print(EACH_ROUND_DELIM.getMessage());
    }

    public static void printWinner(List<String> winners) {
        String winnerMessage = String.join(CARS_JOIN_DELIM.getContent(), winners);

        System.out.print(WINNER_MESSAGE_PREFIX.getMessage() + winnerMessage);
    }
}
