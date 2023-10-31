package racingcar.model;

import java.util.List;

public class CarNameValidator {
    private final List<Car> carNameList;

    public CarNameValidator(List<Car> carNameList) {
        this.carNameList = carNameList;
    }

    private void isWrongNameSize() {
        carNameList.stream()
                .filter(car -> car.getName().length() > 5)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("자동차 이름은 5글자가 넘으면 안됩니다.");
                });
    }
}
