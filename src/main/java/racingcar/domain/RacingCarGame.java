package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Input input;
    private Output output;
    private int moveCount;
    private List<Car> carList;

    public RacingCarGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
    }

    public void start() {
        getInput();
    }

    private void getInput() {
        output.printCarNamesInputRequest();
        List<String> carNameList = input.getCarNames();
        carList = makeCarList(carNameList);

        output.printMoveCountInputRequest();
        moveCount = input.getMoveCount();
    }

    private List<Car> makeCarList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}