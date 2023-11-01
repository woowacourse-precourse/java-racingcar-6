package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.MessageConst;

public class Cars {
    List<Car> cars;
    RandomGenerator randomGenerator = new RandomGenerator();

    public Cars(String carNames) {
        cars = Arrays.stream(carNames.split(MessageConst.DELIMITER))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forward() {
        for (Car car : cars) {
            car.forward(randomGenerator.createNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
