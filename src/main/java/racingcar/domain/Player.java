package racingcar.domain;

import java.util.List;

class Player {
    private final Reader reader;
    private List<Car> cars;

    Player(Reader reader) {
        this.reader = reader;
    }

    void createCars() {
        cars = reader.readNames().stream()
            .map(name -> new Car(name, 0L))
            .toList();
    }
}
