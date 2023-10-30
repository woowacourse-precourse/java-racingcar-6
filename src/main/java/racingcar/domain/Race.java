package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private final Count count;

    public Race(Cars cars, Count count) {
        this.cars = cars;
        this.count = count;
    }

    public void run() {
        cars.run();
        count.decrease();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public boolean playable() {
        return count.playable();
    }
}
