package racingcar.domain;

import racingcar.global.ErrorMessage;
import racingcar.global.RaceException;

import java.util.HashMap;
import java.util.Map;

public class CarGroup {
    private Map<String, Integer> cars;

    // General constructor
    public CarGroup(Map<String, Integer> cars) {
        this.cars = cars;
    }

    // Factory method creating object
    public static CarGroup from(String carNamesCombinedWithComma) {
        Map<String, Integer> cars = new HashMap<>();
        for (String carName : carNamesCombinedWithComma.split(",")) {
            if (cars.containsKey(carName)) {
                throw RaceException.of(ErrorMessage.DUPLICATED_CAR_NAME);
            }
            cars.put(carName, 0);
        }
        return new CarGroup(cars);
    }
}
