package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(final List<Name> carNameList) {
        validate(carNameList);
        this.carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
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
