package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.InputValidator;

public class RaceController {
    public static final String DELIMITER = ",";

    public void run() {

    }

    public List<String> askCarNames() {
        String inputNames = Console.readLine();
        return divideCarNames(inputNames);
    }

    public int askMoveCount() {
        String inputMoveCount = Console.readLine();
        int moveCount = Integer.valueOf(inputMoveCount);

        return moveCount;
    }

    public List<String> divideCarNames(String inputNames) {
        List<String> carNames = Arrays.asList(inputNames.split(DELIMITER));
        InputValidator.validateCarNamesSize(carNames);
        InputValidator.validateCarNameLength(carNames);

        return carNames;
    }

    public List<Car> createCars() {
        return null;
    }
}
