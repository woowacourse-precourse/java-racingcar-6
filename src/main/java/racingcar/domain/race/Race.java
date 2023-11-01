package racingcar.domain.race;

import racingcar.domain.car.Cars;

public class Race {
    private static final String RACE_RESULT_DELIMITER = "\n";

    private Cars cars;
    private Count count;

    public Race(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void runOneCycle() {
        cars.moveAll();
        count.decrease();
    }

    public boolean isOver() {
        return count.isOver();
    }

    @Override
    public String toString() {
        return cars.toString() + RACE_RESULT_DELIMITER;
    }

    public String toWinnerResultString() {
        return cars.getWinnerNames().toString();
    }
}
