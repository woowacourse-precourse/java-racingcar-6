package racingcar.domain;

import java.util.List;
import racingcar.utils.NumberGenerator;

public class Judgment {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public Judgment(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public Cars judge() {
        cars.move(numberGenerator);
        return cars;
    }

    public WinnerNames award() {
        List<Car> winners = cars.findWinners();
        return new WinnerNames(winners);
    }
}
