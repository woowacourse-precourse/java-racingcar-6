package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingcarGame {

    private List<Car> racingcars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int tryCount;

    public void run() {
        String[] carNames = getCarNames();
        tryCount = getTryCount();
        makeCars(carNames);
        runRounds(tryCount);
        calculateWinners(racingcars);
        InputOutput.printWinner(winners);
    }

    private String[] getCarNames() {
        String carNamesWithComma = InputOutput.getCarNames();
        String[] carNames = carNamesWithComma.split(",");
        Validator.carNames(carNames);
        return carNames;
    }

    private int getTryCount() {
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
            if (Random.isNumOverFour()) {
                car.moveForward();
            }
            int moveCount = car.getMoveCount();
            InputOutput.printRoundResult(name, moveCount);
        }
        System.out.println();
    }

    private void calculateWinners(List<Car> cars) {
        int maximumMoveCount = 0;
        for (Car car : cars) {
            int moveCount = car.getMoveCount();
            String name = car.getName();
            if (moveCount > maximumMoveCount) {
                winners = new ArrayList<>(); // 비우기
                winners.add(name);
                maximumMoveCount = moveCount;
            } else if (moveCount == maximumMoveCount) {
                winners.add(name);
            }
        }
    }
}
