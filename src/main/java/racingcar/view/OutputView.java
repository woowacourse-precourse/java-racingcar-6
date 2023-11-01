package racingcar.view;

import static racingcar.constant.ViewMessage.GAME_RESULT;
import static racingcar.constant.ViewMessage.INSERT_CARS_NAMES;
import static racingcar.constant.ViewMessage.INSERT_MOVING_COUNT;

import racingcar.constant.ViewMessage;
import racingcar.dto.RaceResultTexts;

public class OutputView {
    private OutputView() {
    }

    public static void printInsertCarNames() {
        printlnViewMessage(INSERT_CARS_NAMES);
    }

    public static void printInsertMovingCount() {
        printlnViewMessage(INSERT_MOVING_COUNT);
    }

    public static void printGameResultStart() {
        System.out.println();
        printlnViewMessage(GAME_RESULT);
    }

    public static void printResult(RaceResultTexts totalResults) {
        System.out.println(totalResults.convertTotalOneLine());
    }

    public static void printWinner(String winner) {
        System.out.print(winner);
    }

    private static void printlnViewMessage(ViewMessage message) {
        System.out.println(message.toString());
    }
}
