package racingcar.game.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static int carNameLimit = 5;

    public static List<Car> createByNames(List<String> carNames) {
        return carNames.stream()
                .map(CarFactory::createCar)
                .collect(Collectors.toList());
    }

    public static Car createCar(String name) {
        if (name.length() > carNameLimit) {
            throw new IllegalArgumentException();
        }
        return new Car(name);
    }
}
