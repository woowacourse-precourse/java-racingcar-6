package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_DELIMITER = "\n";

    private final List<Car> carList;

    public Cars(final List<Name> carNameList) {
        validate(carNameList);
        this.carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return carList.stream().map(Car::toString).collect(Collectors.joining(CAR_DELIMITER));
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    private void validate(final List<Name> carNameList) {
        validateDuplication(carNameList);
    }

    private void validateDuplication(final List<Name> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }
}
