package racingcar.domain;

import racingcar.global.ErrorMessage;
import racingcar.global.RaceException;

import java.util.HashMap;
import java.util.Map;

public class CarGroup {
    private Map<String, Integer> cars;

    private CarGroup(Map<String, Integer> cars) {
        this.cars = cars;
    }

    // Creating instance method for factory pattern
    public static CarGroup from(String carNamesCombinedWithComma) {
        Map<String, Integer> cars = new HashMap<>();
        for (String carName : carNamesCombinedWithComma.split(",")) {
            String trimmedCarName = carName.trim();
            validateDuplicate(cars, trimmedCarName);
            validateEmpty(trimmedCarName);
            cars.put(trimmedCarName, 0);
        }
        return new CarGroup(cars);
    }

    private static void validateDuplicate(Map<String, Integer> cars, String carName) {
        if (cars.containsKey(carName)) {
            throw RaceException.of(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    private static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw RaceException.of(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }
}
