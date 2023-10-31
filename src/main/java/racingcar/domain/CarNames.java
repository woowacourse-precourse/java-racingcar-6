package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CarNames {
    private static final String DELIMITER = ",";

    private final List<CarName> carNames;

    public CarNames(String carNames) {
        List<CarName> splitNames = splitToCarName(carNames);
        validateCarLength(splitNames);
        validateDuplicateCarName(splitNames);

        this.carNames = splitNames;
    }

    private List<CarName> splitToCarName(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(CarName::new)
                .toList();
    }

    private void validateCarLength(List<CarName> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 2대 이상이어야 합니다.");
        }
    }

    private void validateDuplicateCarName(List<CarName> carNames) {
        long distinctCarNameCount = carNames.stream().distinct().count();
        if (distinctCarNameCount != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public Cars generateCars() {
        List<Car> list = this.carNames.stream()
                .map(carName -> new Car(carName, new Position(0)))
                .toList();

        return new Cars(list);
    }
}
