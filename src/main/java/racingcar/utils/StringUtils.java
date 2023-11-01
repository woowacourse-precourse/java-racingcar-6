package racingcar.utils;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class StringUtils {
    public static List<Car> readParticipantCars(String input) {
        List<Car> cars = new ArrayList<>();

        input = input.replaceAll(" ", "");
        String[] carNames = input.split(",");

        if (isEmptyString(input, carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }

        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }

        return cars;
    }

    private static boolean isEmptyString(String input, String[] carNames) {
        return input.isEmpty() || carNames.length == 0;
    }
}
