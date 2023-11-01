package racingcar.view;

import static racingcar.constant.Constant.EXECUTION_RESULT_MESSAGE;
import static racingcar.constant.Constant.GAME_WINNER_MESSAGE;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.domain.Car;

public class Output {

    public Output() {
        printExecutionMessage();
    }

    public void printResult(Map<String, Car> fitInRacingCars) {
        fitInRacingCars.forEach((carName, distance)
                -> System.out.println(carName + " : " + distance.getMoveDistanceMark()));
        insertNewLine();
    }

    private void printExecutionMessage() {
        insertNewLine();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    private void insertNewLine() {
        System.out.println();
    }

    public void printFinalResult(List<String> winner) {
        System.out.print(GAME_WINNER_MESSAGE);
        System.out.println(makeWinnerNames(winner));
    }

    public String makeWinnerNames(List<String> winner) {
        return winner.stream().collect(Collectors.joining(", "));
    }

}
