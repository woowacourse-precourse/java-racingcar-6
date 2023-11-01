package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

class Player {
    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int CAN_MOVE_NUMBER = 4;
    private final Reader reader;
    private List<Car> cars;

    Player(Reader reader) {
        this.reader = reader;
    }

    void createCars() {
        cars = reader.readNames().stream()
            .map(name -> new Car(name, 0))
            .toList();
    }

    void moveCars() {
        cars = cars.stream()
            .map(this::moveCarIfGreater)
            .toList();
    }

    private Car moveCarIfGreater(Car car) {
        int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (number >= CAN_MOVE_NUMBER) {
            return car.movedCar();
        }
        return car;
    }

    List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
