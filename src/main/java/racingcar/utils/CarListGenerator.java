package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Constant.COMMA_DELIMITER;

/**
 * 사용자가 자동차 이름 -> "pobi,woni,sola" 을 입력하면
 * List<Car> CarList = [new Car("pobi"), new Car("woni"), new Car("sola")] 을 생성한다.
 */

public class CarListGenerator {

    private CarListGenerator() {}

    public static List<Car> generateCarList(final String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(final String carNames) {
        return List.of(carNames.split(COMMA_DELIMITER));
    }
}
