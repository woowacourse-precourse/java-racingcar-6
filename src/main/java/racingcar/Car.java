package racingcar;

import java.util.HashSet;
import java.util.List;

public class Car {

    private static Car car;
    public List<String> names;  // Car는 원하는 곳에서 한 번만 사용가능하기 때문에, 다른 곳에서 호출될 수 없음

    private Car(List<String> names) {
        this.names = names;
    }


    // Car를 한 곳에서 한 번만 사용 가능 하도록 구현
    public static Car getInstance(List<String> names) {
        if (car == null) {
            car = new Car(names);
            validate(car.names);
            trimCarNames(car.names);
            return car;
        }
        throw new RuntimeException("Car는 한 곳에서 한 번만 사용가능합니다.");
    }

    private static void validate(List<String> carNames) {
        checkCarCount(carNames);
        checkBlankAndLength(carNames);
        checkDuplication(carNames);
    }

    private static void checkCarCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해 주세요.");
        }
    }

    private static void checkBlankAndLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("공백을 입력하지 마세요.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해 주세요.");
            }
        }
    }

    private static void checkDuplication(List<String> carNames) {
        if (carNames.size() > new HashSet<>(carNames).size()) {
            throw new IllegalArgumentException("중복되지 않은 이름을 입력해 주세요.");
        }
    }

    private static void trimCarNames(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carNames.set(i, carNames.get(i).trim());  // 수정 필요
        }
    }

}
