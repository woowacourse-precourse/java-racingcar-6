package racingcar.view;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessgeList.*;

public class OutputView {
    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }
    public static void printMovingForward(){
        System.out.print(FORWARD);
    }
    public static void printMovingStop(){
        System.out.println(MOVING_STOP);
    }
    public static void printWinner(String[] winners) {
        System.out.println(WINNER_MESSAGE + Arrays.stream(winners).map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
