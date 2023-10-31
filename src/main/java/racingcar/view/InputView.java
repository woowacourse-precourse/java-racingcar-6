package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidation;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readRacingCarName(CarNameValidation carNameValidation) {
        String userInput = Console.readLine();
        carNameValidation.validateCarNameAll(userInput);
        return Arrays.asList(userInput.split(","));
    }
}
