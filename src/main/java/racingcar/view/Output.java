package racingcar.view;

import static racingcar.constant.Constant.EXECUTION_RESULT_MESSAGE;

import java.util.Map;

import racingcar.domain.Car;

public class Output {

    public Output() {
        printExecutionMessage();
    }

    public void printResult(Map<String, Car> fitInRacingCars) {
        fitInRacingCars.forEach((carName, distance)
                -> System.out.println(carName + " : " + distance.getMoveDistance()));
        insertNewLine();
    }

    private void printExecutionMessage() {
        insertNewLine();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    private void insertNewLine() {
        System.out.println();
    }


}
