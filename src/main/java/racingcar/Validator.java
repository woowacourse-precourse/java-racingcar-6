package racingcar;

import java.util.List;

import racingcar.Model.Car;

public class Validator {

    public int validatePlayCount(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateCarsNames(List<Car> cars) {
        validateCarsNamesDuplicate(cars);
        validateCarsNamesLength(cars);
        validateCarNamesBlank(cars);
    }

    public void validatelastInputCommas(String input) {
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("이름이 없는 자동차가 있습니다.");
        }
    }

    private void validateCarNamesBlank(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            validateBlankContain(cars.get(i).getName());
        }
    }

    private void validateBlankContain(String input) {
        for (String s : input.split("")) {
            validateBlank(s);
        }
    }

    private void validateBlank(String s) {
        if (s.isBlank()) {
            throw new IllegalArgumentException("이름에 공백이 포함된 자동차가 있습니다.");
        }
    }

    private void validateCarsNamesDuplicate(List<Car> cars) {
        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = i + 1; j < cars.size(); j++) {
                validateEqualCarName(cars.get(i).getName(), cars.get(j).getName());
            }
        }
    }

    private void validateEqualCarName(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("같은 이름의 자동차가 있습니다.");
        }
    }

    private void validateCarsNamesLength(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            validateNameLength(cars.get(i).getName());
            validateEmptyName(cars.get(i).getName());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
        }
    }

    private void validateEmptyName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("이름이 없는 자동차가 있습니다.");
        }
    }
}
