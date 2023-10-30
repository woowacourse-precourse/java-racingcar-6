package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Input {
    RacingCarValidation racingCarValidation = new RacingCarValidation();
    public Map<String, Integer> carNames() {
        Map<String, Integer> carNames = new HashMap<>();
        for (String carName : Console.readLine().split(",")) {
            racingCarValidation.carNameLength(carName.length());
            carNames.put(carName, 0);
        }
        return carNames;
    }

    public int tryCount() {
        String inputValue = Console.readLine();
        return racingCarValidation.number(inputValue);
    }
}