package racingcar.domain;

import java.util.Collections;
import java.util.List;

class Player {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int CAN_MOVE_NUMBER = 4;
    private final NumberGenerator numberGenerator;
    private List<Car> cars;

    Player(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    void addCars(List<String> names) {
        cars = names.stream()
            .map(name -> new Car(name, 0))
            .toList();
    }

    void moveCars() {
        cars = cars.stream()
            .map(this::moveCarIfGreater)
            .toList();
    }

    private Car moveCarIfGreater(Car car) {
        int number = numberGenerator.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (number >= CAN_MOVE_NUMBER) {
            return car.movedCar();
        }
        return car;
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
