package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Name;
import racingcar.model.car.Position;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {
        List<Car> cars = generateCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> generateCars(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Name::from)
                .map(name -> new Car(name, new Position(0)))
                .toList();
    }
}
