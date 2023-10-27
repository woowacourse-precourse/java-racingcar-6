package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import racingcar.validator.InputValidator;

public class Cars {
    private static final int ZERO_POSITION = 0;
    private static final int MIN_MOVE_NUMBER = 4;
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

    private void decideToMove() {
        cars.forEach((name, position) -> {
            if (Randoms.pickNumberInRange(1, 9) >= MIN_MOVE_NUMBER) {
                cars.put(name, position + 1);
            }
        });
    }

}
