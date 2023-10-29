package racingcar.circuit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.result.RacingCarResult;
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
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<RacingCarResult> summarizeRacingResult() {
        return cars.stream().map(Car::toResult).collect(Collectors.toList());
    }
}
