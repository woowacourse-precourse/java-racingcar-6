package racingcar;

import static racingcar.constant.GuideTextConstant.EXECUTION_RESULT_TEXT;
import static racingcar.constant.GuideTextConstant.INPUT_CAR_NAMES_GUIDE_TEXT;
import static racingcar.constant.GuideTextConstant.INPUT_EXECUTION_COUNT_GUIDE_TEXT;

import java.util.List;
import racingcar.input.Input;
import racingcar.output.Output;

public class Game {

    private final Input input;
    private final Output output;

    public Game(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        List<Car> carList = getCarListFromInput();
        int executionCount = getExecutionCountFromInput();

        execution(executionCount, carList);
        printWinner(carList);
    }

    private List<Car> getCarListFromInput() {
        output.printText(INPUT_CAR_NAMES_GUIDE_TEXT);
        return input.receiveCarNamesAndMakeList();
    }

    private int getExecutionCountFromInput() {
        output.printText(INPUT_EXECUTION_COUNT_GUIDE_TEXT);
        return input.receiveTotalCountOfExecution();
    }

    private void execution(int executionCount, List<Car> carList) {
        output.printText(EXECUTION_RESULT_TEXT);
        for (int i = 0; i < executionCount; i++) {
            carList.forEach(Car::moveForward);
            output.printExecutionResult(carList);
        }
    }

    private void printWinner(List<Car> carList) {
        output.printWinner(carList);
    }
}
