package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.CarNameValidation;
import racingcar.validation.RoundValidation;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> readRacingCarName(CarNameValidation carNameValidation) {
        String userInput = Console.readLine();
        carNameValidation.validateCarNameAll(userInput);
        return Arrays.asList(userInput.split(","));
    }

    public int readNumberOfRound(RoundValidation roundValidation) {
        String userInput = Console.readLine();
        roundValidation.validateRoundAll(userInput);
        return Integer.parseInt(userInput);
    }
}
