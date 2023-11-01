package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private List<Car> racingcars = new ArrayList<>();
    private List<String> winners;
    private int tryCount;
    private int maxMoveCount = 0;

    public void start() throws IllegalArgumentException {
        set();
        run();
    }

    private void set() throws IllegalArgumentException {
        String[] carNames = getCarNames();
        tryCount = getTryCount();
        makeCars(carNames);
    }

    private void run() {
        runRounds(tryCount);
        setWinners(racingcars);
        printWinners();
    }

    private String[] getCarNames() throws IllegalArgumentException {
        String carNamesWithComma = InputOutput.getCarNames();
        String[] carNames = carNamesWithComma.split(",");
        Validator.carNames(carNames);
        return carNames;
    }

    private int getTryCount() throws IllegalArgumentException {
        String tryCountString = InputOutput.getTryCount();
        tryCount = Validator.tryCountInput(tryCountString);
        InputOutput.printEmptyLine();
        return tryCount;
    }

    private void makeCars(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            racingcars.add(car);
        }
    }

    private void runRounds(int tryCount) {
        InputOutput.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            runRound(racingcars);
        }
    }

    private void runRound(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            if (Random.isOverThresholdNum()) {
                car.moveForward();
            }
            int moveCount = car.getMoveCount();
            InputOutput.printRoundResult(name, moveCount);
        }
        System.out.println();
    }

    private void setWinners(List<Car> cars) {
        initializeWinners();
        for (Car car : cars) {
            setWinner(car);
        }
    }

    private void setWinner(Car car) {
        int moveCount = car.getMoveCount();
        String name = car.getName();
        if (moveCount > maxMoveCount) {
            initializeWinners();
            winners.add(name);
            maxMoveCount = moveCount;
        } else if (moveCount == maxMoveCount) {
            winners.add(name);
        }
    }

    private void printWinners() {
        InputOutput.printWinners(winners);
    }

    private void initializeWinners() {
        winners = new ArrayList<>();
    }
}
