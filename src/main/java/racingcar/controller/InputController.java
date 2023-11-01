package racingcar.controller;

import static racingcar.constant.Constant.SEPARATOR_CHAR;

import java.util.Arrays;
import java.util.List;
import racingcar.model.RacingCars;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;
import racingcar.validation.InputValidation;

public class InputController {

    private InputController() {
    }

    public static RacingCars toRacingCars(String input) {
        InputValidation.isEmptyInput(input);
        List<String> carNameList = splitStringToListWithTrim(input);
        CarNameValidation.validate(carNameList);

        return new RacingCars(carNameList);
    }

    public static Integer toMoveCount(String input) {
        InputValidation.isEmptyInput(input);
        CountValidation.validate(input);
        return Integer.parseInt(input);
    }

    private static List<String> splitStringToListWithTrim(String carName) {
        return Arrays.stream(carName.split(SEPARATOR_CHAR))
                .map(String::trim)
                .toList();
    }
}
