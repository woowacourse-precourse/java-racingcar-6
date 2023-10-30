package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.util.validation.InputValidator.InputValidator;

public class InputView {

    private static final String SPLIT_DELIMITER = ",";

    public List<String> getUserInputCarNames() {
        String userInput = Console.readLine();
        InputValidator.validateUserInput(userInput);
        List<String> userInputList = Arrays.asList(userInput.split(SPLIT_DELIMITER));
        InputValidator.validateUserInputList(userInputList);
        return userInputList;
    }

    public int getUserInputRacingRound() {
        String inputRacingRound = Console.readLine();
        return InputValidator.validateRacingRound(inputRacingRound);
    }

}
