package racingcar.view;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessgeList.EXECUTION_RESULT_MESSAGE;
import static constant.MessgeList.WINNER_MESSAGE;

public class OutputView {
    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printExecutionResult(String carName) {
        Car car = new Car();
        System.out.print(carName + " : ");
        if (car.isCarMoveForward()) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printSoleWinner(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    public static void printJointWinner(String[] winners) {
        System.out.println(WINNER_MESSAGE + Arrays.stream(winners).map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
