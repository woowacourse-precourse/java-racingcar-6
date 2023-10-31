package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputManager;

public class RacingGame {
    private final Integer gameCycle;
    private final Cars cars;

    public RacingGame(Integer gameCycleNumber, Cars cars) {
        this.gameCycle = gameCycleNumber;
        this.cars = cars;
    }

    public void playGame() {
        for (int i = 0; i < this.gameCycle; i++) {
            cars.moveByCycle();
            printEachCycleResult(cars);
        }
        printWinner(cars);
    }

    private void printEachCycleResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            OutputManager.printEachCycleResult(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    private void printWinner(Cars cars) {
        List<String> winnerNames = cars.winner();
        OutputManager.printWinner(winnerNames.stream().collect(Collectors.joining(", ")));
    }
}
