package racingcar.sevice;

import racingcar.util.OutputManager;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;


public class Race {

    private final List<Car> cars;
    private final int trials;
    private final List<Car> winners;

    public Race(List<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
        this.winners = new ArrayList<>();
    }

    public void executeRace() {
        OutputManager.displayRaceHeader();

        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                car.move();
                OutputManager.displayCarPosition(car);
            }
            OutputManager.displayBlankLine();
        }
        determineWinners();
    }

    private void determineWinners() {
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
    }

    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getWinners() {
        return winners;
    }

}
