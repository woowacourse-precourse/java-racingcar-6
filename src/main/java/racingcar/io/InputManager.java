package racingcar.io;

import racingcar.config.GameConfig;
import racingcar.utils.StringSplitter;
import racingcar.utils.provider.InputProvider;
import racingcar.utils.validator.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class InputManager {
    private final OutputManager outputManager;
    private final InputProvider inputProvider;
    private static final String SPLIT_DELIMITER = ",";

    public InputManager(OutputManager outputManager, InputProvider inputProvider) {
        this.outputManager = outputManager;
        this.inputProvider = inputProvider;
    }

    public String readCarNameInput() {
        outputManager.printCarNameInputMessage();
        String input = inputProvider.getInput();
        return getValidatedInput(getCarNameValidators(StringSplitter.split(input, SPLIT_DELIMITER)), input);
    }
    public String readTryCountInput() {
        outputManager.printTryCountInputMessage();
        String input = inputProvider.getInput();
        return getValidatedInput(getTryCountValidators(), input);
    }

    private List<Predicate<String>> getCarNameValidators(List<String> CarNames) {
        return Arrays.asList(
                input -> NoWhitespaceValidator.validate(input),
                input -> AsciiValidator.validate(input),
                input -> NotEmptyValidator.validate(CarNames),
                input -> LengthValidator.validate(CarNames, GameConfig.MAX_CAR_NAME_LENGTH.getValue()),
                input -> UniqueNameValidator.validate(CarNames)
        );
    }

    private List<Predicate<String>> getTryCountValidators() {
        return Arrays.asList(
                input -> IsIntegerValidator.validate(input),
                input -> IntegerRangeValidator.validate(input,
                        GameConfig.MIN_TRY_COUNT.getValue(), GameConfig.MAX_TRY_COUNT.getValue())
        );
    }

    private String getValidatedInput(List<Predicate<String>> validators, String input) {
        boolean isValid = validators.stream().allMatch(validator -> validator.test(input));
        if (!isValid) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}
