package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.validation.GameInputValidator;

public class InputView {

    public final static String DELIMITER = ",";

    public List<String> carNameListInput() {
        String userInput = Console.readLine();
        GameInputValidator.validationCarNames(userInput);

        return Arrays.asList(userInput.split(DELIMITER));
    }

    public int totalAttemptsInput() {
        String userInput = Console.readLine();
        GameInputValidator.validateIsPositiveInteger(userInput);

        return Integer.parseInt(userInput);
    }

}


