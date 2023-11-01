package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
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
        String carNamesWithComma = View.getCarNamesWithComma();
        String[] carNames = getCarNames(carNamesWithComma);
        String tryCountString = View.getTryCount();
        tryCount = getTryCount(tryCountString);
        makeCars(carNames);
    }

    private void run() {
        runRounds(tryCount);
        setWinners(racingcars);
        printWinners();
    }

    public String[] getCarNames(String carNamesWithComma) throws IllegalArgumentException {
        String[] carNames = carNamesWithComma.split(",");
        Validator.carNames(carNames);
        return carNames;
    }

    public int getTryCount(String tryCountString) throws IllegalArgumentException {
        tryCount = Validator.tryCountInput(tryCountString);
        View.printEmptyLine();
        return tryCount;
    }

    public void makeCars(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            racingcars.add(car);
        }
    }

    private void runRounds(int tryCount) {
        View.printResultMessage();
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
            View.printRoundResult(name, moveCount);
        }
        System.out.println();
    }

    private void setWinners(List<Car> cars) {
        initializeWinners();
        for (Car car : cars) {
            setWinner(car);
        }
    }

    private void initializeWinners() {
        winners = new ArrayList<>();
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
        View.printWinners(winners);
    }
}
