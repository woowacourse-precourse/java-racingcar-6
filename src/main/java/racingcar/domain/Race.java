package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import racingcar.constant.Console;
import racingcar.constant.Game;
import racingcar.util.RandomNumberGenerator;

public class Race {
    private final List<Car> cars;
    private final int totalRound;
    private int bestScore;

    public Race(int totalRound) {
        this.cars = new ArrayList<>();
        this.totalRound = totalRound;
        this.bestScore = 0;
    }

    private void entry(Car car) {
        cars.add(car);
    }

    public void entry(String[] names) {
        for (String name : names) {
            entry(new Car(name));
        }
    }

    public void start() {
        System.out.println();
        System.out.println(Console.RESULT.message());
        for (int time = 0; time < totalRound; time++) {
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
        StringJoiner winners = new StringJoiner(Console.PRINT_DELIMITER.message());

        for (Car car : cars) {
            if (car.getDistance() == bestScore) {
                winners.add(car.getName());
            }
        }

        System.out.println(Console.WINNER.message() + winners);
    }
}
