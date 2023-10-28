package racingcar;

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
        List<Car> carList = getCars();
        int executionCount = getExecutionCount();

        execution(executionCount, carList);
        printWinner(carList);
    }

    private List<Car> getCars() {
        output.printText("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = input.receiveCarNamesAndMakeList();
        return carList;
    }

    private int getExecutionCount() {
        output.printText("시도할 회수는 몇회인가요?");
        int execution = input.receiveTotalCountOfExecution();
        return execution;
    }

    private void execution(int execution, List<Car> carList) {
        output.printText("실행 결과");
        for (int i = 0; i < execution; i++) {
            carList.forEach(Car::moveForward);
            output.printExecutionResult(carList);
        }
    }

    private void printWinner(List<Car> carList) {
        output.printWinner(carList);
    }
}
