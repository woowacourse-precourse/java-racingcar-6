package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

class Player {
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
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            return car.movedCar();
        }
        return car;
    }
}
