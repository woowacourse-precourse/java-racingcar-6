package racingcar.view;

import racingcar.common.consts.SystemMessage;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarsResult;

public class OutputView {
    public static void print(String text) {
        System.out.print(text);
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void printErrMessage(String text) {
        System.out.println(text);
    }

    public static void printInputCarMessage() {
        println(SystemMessage.INPUT_CAR_MESSAGE);
    }

    public static void printInputChanceNumberMessage() {
        println(SystemMessage.INPUT_CHANCE_NUMBER_MESSAGE);
    }

    public static void printExecutionResultMessage() {
        println(SystemMessage.EXECUTION_RESULT_MESSAGE);
    }

    public static void printFinalWinnerMessage() {
        println(SystemMessage.FINAL_WINNER_MESSAGE);
    }

    public static void printRacingCarsMoveMessage(RacingCars racingCars) {
        println(racingCars.toString());
    }

    public static void printRacingCarsWinnersMessage(RacingCarsResult racingCarsResult) {
        print(SystemMessage.FINAL_WINNER_MESSAGE);
        print(racingCarsResult.toString());
    }

}
