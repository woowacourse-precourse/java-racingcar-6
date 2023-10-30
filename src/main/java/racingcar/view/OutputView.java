package racingcar.view;

import static racingcar.config.GameMessage.ATTEMPT_COUNT_INPUT_MESSAGE;
import static racingcar.config.GameMessage.CAR_NAME_INPUT_MESSAGE;
import static racingcar.config.GameMessage.GAME_RESULT_MESSAGE;
import static racingcar.config.GameMessage.ONE_MOVE_DISTANCE;
import static racingcar.config.GameMessage.REAL_TIME_RESULT_FORM;
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

    public static void printRealTimeResult(String carName, int moveLength) {
        String form = REAL_TIME_RESULT_FORM.getMessage();
        String distance = ONE_MOVE_DISTANCE.getMessage();

        System.out.printf(form, carName, distance.repeat(moveLength));
    }

    public static void printWinner(List<String> winners) {
        String winnerMessage = String.join(CARS_JOIN_DELIM.getContent(), winners);

        System.out.println(WINNER_MESSAGE_PREFIX.getMessage() + winnerMessage);
    }
}
