package racingcar.domain;

import java.util.List;

public class Racing {
    private final List<Car> racingCar;

    public Racing(final List<Car> racingList) {
        this.racingCar = racingList;
    }

    public void run(Judgment judgment, NumberGenerator generator) {
        racingCar.forEach(car -> {
            car.forward(judgment, generator.createRandomNumber());
            printCarLocation(car);
        });
        System.out.println();
    }

    private void printCarLocation(Car car) {
        System.out.println(car.currentLocation());
    }
}
