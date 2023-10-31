package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private final Count count;
    private final NumberGenerator numberGenerator;

    public Race(Cars cars, Count count, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.count = count;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        cars.run(numberGenerator);
        count.decrease();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public boolean playable() {
        return count.playable();
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
