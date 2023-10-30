package racingcar.domain;

import java.util.List;

public class Racing {
    private final List<Car> racingCar;

    public Racing(final List<Car> racingList) {
        this.racingCar = racingList;
    }

    public void run() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (Car car : racingCar) {
            if (shouldCarMoveForward(numberGenerator)) {
                car.forward();
            }
            printCarLocation(car);
        }
        System.out.println();
    }

    private boolean shouldCarMoveForward(NumberGenerator numberGenerator) {
        Judgment judgment = new Judgment();
        return judgment.isMoreThanFour(numberGenerator.createRandomNumber());
    }

    private void printCarLocation(Car car) {
        System.out.println(car.currentLocation());
    }
}
