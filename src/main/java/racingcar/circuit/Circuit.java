package racingcar.circuit;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.generator.NumberGenerator;

public class Circuit {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Circuit(NumberGenerator numberGenerator) {
        this.cars = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void addRacingCar(Car car) {
        cars.add(car);
    }

    public void tryRacingGame() {

    }
}
