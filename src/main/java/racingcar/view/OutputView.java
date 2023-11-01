package racingcar.view;

import racingcar.enums.OutputMessage;
import racingcar.model.Cars;

public class OutputView {
    public static void printStartMessageOfResult() {
        System.out.println(OutputMessage.START_OF_RESULT.getMessage());
    }

    public static void printProgressAfterCarForward(Cars cars) {
        System.out.println(cars.getForwardResultMessageAll());
    }

    public static void printWinnerOfGameMessage(Cars cars) {
        System.out.println(cars.toString());
    }

    public static void printLineFeed() {
        System.out.println();
    }
}
