package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private final List<Car> carList;

    public CarNameValidator(List<Car> cars) {
        this.carList = cars;
        carNameValidation();
    }

    public void carNameValidation() {
        isWrongNameSize();
        isDuplicateName();
        hasBlankOrEmpty();
    }

    private void isWrongNameSize() {
        carList.stream()
                .filter(car -> car.getName().length() > 5)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException("자동차 이름은 5글자가 넘으면 안됩니다.");
                });
    }

    private void isDuplicateName() {
        Set<String> checkName = new HashSet<>();
        carList.stream()
                .map(Car::getName)
                .filter(name -> !checkName.add(name))
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException("자동차의 이름이 중복되면 안됩니다.");
                });
    }

    private void hasBlankOrEmpty() {
        if (carList.stream().anyMatch(car -> car.getName().isBlank())) {
            throw new IllegalArgumentException("자동차의 이름에 공백이 들어가면 안됩니다.");
        }
    }

}
