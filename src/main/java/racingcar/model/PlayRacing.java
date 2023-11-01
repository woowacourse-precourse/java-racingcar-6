package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.util.NumberGenerator;

public class PlayRacing {

    private final NumberGenerator numberGenerator;
    private final Cars cars;

    public PlayRacing(NumberGenerator numberGenerator, Cars cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public RacingResult end() {
        return new RacingResult(cars);
    }

    public Cars process() {
        cars.updateDistance(createPickNumberOfCars());
        return cars;
    }

    private List<Integer> createPickNumberOfCars() {
        return IntStream.range(0, cars.carsSize())
                .mapToObj(number -> numberGenerator.pickNumber())
                .toList();
    }
}
