package racingcar.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static racingcar.exception.ExceptionMessage.NO_CAR_AVAILABLE;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(List<String> CarNameList) {
        return CarNameList.stream()
                .map(Car::create)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    public List<Car> getMaxPositionCars() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(NO_CAR_AVAILABLE));

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
