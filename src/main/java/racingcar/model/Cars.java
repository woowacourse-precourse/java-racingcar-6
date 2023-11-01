package racingcar.model;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static racingcar.exception.ExceptionMessage.CAR_NAME_CANNOT_BE_DUPLICATE;
import static racingcar.exception.ExceptionMessage.NO_CAR_AVAILABLE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> carList) {
        validate(carList);
        this.carList = carList;
    }

    public static Cars from(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::from)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    private void validate(List<Car> carList) {
        if (hasDuplicateName(carList)) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_BE_DUPLICATE);
        }
    }

    private boolean hasDuplicateName(List<Car> carList) {
        Set<String> distinctNameSet = carList.stream().map(Car::getName)
                .collect(Collectors.toSet());
        return distinctNameSet.size() < carList.size();
    }

    public List<Car> getMaxPositionCars() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(NO_CAR_AVAILABLE));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
