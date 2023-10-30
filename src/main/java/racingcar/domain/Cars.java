package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = new ArrayList<>();
        validateDuplicateName(carNames);
        for (String name: carNames) {
            carList.add(new Car(name));
        }
    }

    private final static String DUPLICATE_INPUT = "자동차 이름이 중복입니다.";

    private void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT);
        }
    }

    private final static String NULL_VALUE_ERROR_MESSAGE = "자동차 목록이 비어있습니다.";

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NULL_VALUE_ERROR_MESSAGE));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCarList() {
        return carList;
    }
}
