package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    Cars(String carNames) {
        validateNullOrEmpty(carNames);
        validateLastCharComma(carNames);
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        validateDuplicate();
    }

    private void validateNullOrEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
    }

    private void validateLastCharComma(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == ',') {
            throw new IllegalArgumentException("쉼표(,)로 끝날 수 없습니다");
        }
    }

    private void validateDuplicate() {
        int distinctSize = cars.stream()
                .distinct()
                .toList()
                .size();

        if (cars.size() != distinctSize) {
            throw new IllegalArgumentException("자동차 이름이 중복된 값이 있습니다.");
        }
    }

}
