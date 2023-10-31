package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import racingcar.constant.Console;
import racingcar.constant.Game;
import racingcar.util.RandomNumberGenerator;

public class Race {
    private final List<Car> cars;
    private final int totalTime;
    private int bestScore;

    public Race(int totalTime) {
        this.cars = new ArrayList<>();
        this.totalTime = totalTime;
        this.bestScore = 0;
    }

    public void entry(Car car) {
        cars.add(car);
    }

    public void start() {
        for (int time = 0; time < totalTime; time++) {
            moveCars();
            printStatus();
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber >= Game.MOVE_CONDITION.is()) {
                car.move();
                renewBestScore(car);
            }
        }
    }

    private void renewBestScore(Car car) {
        bestScore = Math.max(bestScore, car.getDistance());
    }

    public void printWinner() {
        StringJoiner winners = new StringJoiner(", ");

        for (Car car : cars) {
            if (car.getDistance() == bestScore) {
                winners.add(car.getName());
            }
        }

        System.out.println(Console.WINNER.message() + winners);
    }
}
