package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private Input input;
    private Output output;
    private Referee referee;
    private int moveCount;
    private List<Car> carList;

    public RacingCarGame() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
        this.referee = new Referee();
    }

    public void start() {
        getInput();
        output.printResultStartedMessage();
        while (!isFinish()) {
            moveCars();
            printCarsState();
        }

        List<String> winnerNameList = referee.getWinner(carList);
        output.printWinner(winnerNameList);
    }

    private void printCarsState() {
        for (Car car : carList) {
            output.addCarState(car.getName(), car.getPath());
        }
        output.printCarsState();
    }

    private void moveCars() {
        for (Car car : carList) {
            car.moveOrStop();
        }
        moveCount--;
    }

    private boolean isFinish() {
        return (moveCount == 0);
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