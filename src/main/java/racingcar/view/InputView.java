package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Constants;
import racingcar.validator.InputValidator;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println(Constants.INPUT_CAR_NAMES_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateNotInputComma(input);
        InputValidator.validateInputCarNameCharacter(input);
        InputValidator.validateInputCarNameLength(input);
        InputValidator.validateDuplicationCarNames(input);

        return converterCarNames(input);
    }

    public int inputTryCount() {
        System.out.println(Constants.INPUT_TRY_COUNT_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputTryCountCharacter(input);
        InputValidator.validateInputTryCountZero(input);

        return Integer.parseInt(input);
    }

    private List<String> converterCarNames(final String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(name -> name.trim())
                .toList();
    }
}
