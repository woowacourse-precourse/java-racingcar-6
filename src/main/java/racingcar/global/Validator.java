package racingcar.global;

import java.util.List;

import racingcar.Race;
import racingcar.global.util.NumberUtil;

public class Validator {
    public static List<String> carName(List<String> cars) {
        if (cars.size() == 0) {
            throw new IllegalArgumentException();
        }

        boolean result = cars
                .stream()
                .allMatch(car -> 0 < car.length() && car.length() <= Race.MAX_CAR_NAME_LENGTH);
        if (result) {
            return cars;
        }
        throw new IllegalArgumentException();
    }

    public static Integer count(String count) {
        Integer number = NumberUtil.parseIntOrThrowException(count);
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return number;
    }
}
