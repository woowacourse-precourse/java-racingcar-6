package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private void isDuplicateName() {
        Set<String> checkName = new HashSet<>();
        carNameList.stream()
                .map(Car::getName)
                .filter(name -> !checkName.add(name))
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("자동차의 이름이 중복되면 안됩니다.");
                });
    }
}
