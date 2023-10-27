package racingcar.util;

import static racingcar.constant.Message.*;

import java.util.Arrays;

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

    public void printRoundResult(String[] carNames) {
        Arrays.stream(carNames).forEach(System.out::println);
    }

    public void printWinnersName(String[] carNames) {
        Arrays.stream(carNames).forEach(System.out::println);
    }
}
