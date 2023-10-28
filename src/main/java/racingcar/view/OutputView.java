package racingcar.view;

import racingcar.model.MovingCar;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessgeList.EXECUTION_RESULT_MESSAGE;
import static constant.MessgeList.WINNER_MESSAGE;

public class OutputView {
    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printExecutionResult(String carName) {
        MovingCar movingCar = new MovingCar();
        System.out.print(carName + " : ");
        if (movingCar.isCarMoveForward()) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printSoleWinner(String winner) {
        System.out.println(WINNER_MESSAGE + winner);
    }

    public static void printJointWinner(List<String> winners) {
        System.out.println(WINNER_MESSAGE + winners.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
