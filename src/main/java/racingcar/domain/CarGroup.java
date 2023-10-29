package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.ErrorMessage;
import racingcar.global.RaceException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.global.Constant.*;

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
            validateLength(trimmedCarName);
            validateDuplicate(cars, trimmedCarName);
            validateEmpty(trimmedCarName);
            cars.put(trimmedCarName, 0);
        }
        return new CarGroup(cars);
    }

    private static void validateLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw RaceException.of(ErrorMessage.EXCEED_CAR_NAME_LENGTH);
        }
    }

    private static void validateDuplicate(Map<String, Integer> cars, String carName) {
        if (cars.containsKey(carName)) {
            throw RaceException.of(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    private static void validateEmpty(String carName) {
        if (carName.isEmpty()) {
            throw RaceException.of(ErrorMessage.EMPTY_CAR_NAME);
        }
    }

    public void moveAllProbabilistically() {
        cars.replaceAll((carName, position) -> {
            if (Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX) >= RANDOM_NUMBER_THRESHOLD) {
                return position + 1;
            }
            return position;
        });
    }

    public String getStatusAsString() {
        List<String> results = cars
                .entrySet()
                .stream()
                .map(entry -> String.format("%s : %s", entry.getKey(), "-".repeat(entry.getValue())))
                .collect(Collectors.toList());
        return String.join("\n", results);
    }
}
