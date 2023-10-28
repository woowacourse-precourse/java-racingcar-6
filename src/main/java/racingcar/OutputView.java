package racingcar;

import java.util.List;

import static racingcar.GameMessage.INPUT_CAR_MESSAGE;
import static racingcar.GameMessage.INPUT_ATTEMPT_MESSAGE;
import static racingcar.GameMessage.OUTPUT_RESULT_MESSAGE;
import static racingcar.GameMessage.OUTPUT_WINNER_MESSAGE;

public class OutputView {

    public static void printRequestCar() {
        System.out.println(INPUT_CAR_MESSAGE);
    }

    public static void printRequestAttempt() {
        System.out.println(INPUT_ATTEMPT_MESSAGE);
    }

    public static void printGameResult() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
    }

    public static void printEnter() {
        System.out.println();
    }

    public static void printGameWinner(List<String> winner) {
        String result = String.join(",", winner);
        System.out.println(OUTPUT_WINNER_MESSAGE + result);
    }
}
