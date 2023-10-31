package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarsFactory {

    public static Cars createCars(List<String> carNames) {
        List<Car> carList = mapFrom(carNames);
        return new Cars(carList);
    }

    private static List<Car> mapFrom(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(carName -> new Car(new CarName(carName), new Position(0)))
                .collect(Collectors.toList());
        return carList;
    }
}
