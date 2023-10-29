package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.util.Constants;
import racingcar.validator.InputValidator;

public class InputView {
    public Cars inputCars() {
        System.out.println(Constants.INPUT_CAR_NAMES_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateNotInputComma(input);
        InputValidator.validateInputCarNameCharacter(input);
        InputValidator.validateInputCarNameLength(input);
        InputValidator.validateDuplicationCarNames(input);

        return convertToCars(input);
    }

    public int inputTryCount() {
        System.out.println(Constants.INPUT_TRY_COUNT_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputTryCountCharacter(input);
        InputValidator.validateInputTryCountZero(input);

        return Integer.parseInt(input);
    }

    private Cars convertToCars(final String input) {
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        return new Cars(carNames);
    }
}
