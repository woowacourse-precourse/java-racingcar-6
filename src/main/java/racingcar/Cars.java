package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {

    private List<Car> cars;

    Cars(String carNames) {
        validateNullOrEmpty(carNames);
        validateLastCharComma(carNames);
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
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

}
