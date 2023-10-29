package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private int count;

    public Race(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void run() {
        cars.run();
        count -= 1;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public boolean play() {
        return count != 0;
    }
}
