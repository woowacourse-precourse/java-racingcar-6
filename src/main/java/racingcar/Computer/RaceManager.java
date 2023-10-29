package racingcar.Computer;

import racingcar.Car.Car;
import racingcar.Car.CarMover;
import racingcar.View.OutputView;

import java.util.List;

public class RaceManager {
    private final List<Car> cars;
    private final int rounds;

    public RaceManager(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
    public int getRounds() {
        return rounds;
    }
    public void startRace() {
        for (int i = 0; i < rounds; i++) {
            raceRound();
        }
    }

    private void raceRound() {
        CarMover.moveCars(cars);
        OutputView.printCars(cars);
    }
}
