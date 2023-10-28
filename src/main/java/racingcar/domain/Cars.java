package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private static final String CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "중복된 이름을 입력하면 안 됩니다.";
    private static final String WINNER_DELIMITER = ", ";

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        validateName(carList);
        this.carList = carList;
    }

    public List<String> moveCars(RandomNumberGenerator randomNumberGenerator) {
        return carList.stream()
                .map(car -> car.move(randomNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

    public String findWinnerCars() {
        int maxLocationLength = getMaxLocationLength();
        return carList.stream()
                .filter(car -> car.getLocationLength() == maxLocationLength)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private void validateName(List<Car> cars) {
        Set<Car> carSet = new HashSet<>(cars);

        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private int getMaxLocationLength() {
        return carList.stream()
                .mapToInt(Car::getLocationLength)
                .max()
                .orElse(0);
    }
}
