package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;
    RandomGenerator randomGenerator = new RandomGenerator();

    public List<Car> getCars() {
        return cars;
    }

    public Cars(String carNames) {
        cars = Arrays.stream(carNames.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void forward() {
        for (Car car : cars) {
            car.forward(randomGenerator.createNumber());
        }
    }
}
