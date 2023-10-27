package racingcar.model;

import java.util.HashMap;
import java.util.Map;
import racingcar.validator.InputValidator;

public class Cars {
    private static final int ZERO_POSITION = 0;
    Map<Name, Integer> cars;

    public Cars(String names) {
        InputValidator.validateCarNames(names);
        cars = generateCars(names);
    }

    private Map<Name, Integer> generateCars(String names) {
        Map<Name, Integer> carMap = new HashMap<>();
        String[] carNamesArray = names.split(",");
        for (String carName : carNamesArray) {
            carMap.put(new Name(carName), ZERO_POSITION);
        }
        return carMap;
    }

}
