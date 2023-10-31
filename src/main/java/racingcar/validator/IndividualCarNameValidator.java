package racingcar.validator;

import static racingcar.config.ErrorMessage.SPLIT_CAR_LENGTH_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.SPLIT_CAR_REGEX_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.SPLIT_CAR_UNIQUE_ERROR_MESSAGE;
import static racingcar.config.InputPattern.SPLIT_CAR_NAME_LENGTH_REGEX;
import static racingcar.config.InputPattern.SPLIT_CAR_NAME_REGEX;
import static racingcar.config.RacingConfig.CARS_JOIN_DELIM;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.util.ErrorThrower;
import racingcar.util.PatternChecker;

public class IndividualCarNameValidator implements Validator<List<String>> {
    private static final Pattern SPLIC_CAR_NAME_PATTERN =
            Pattern.compile(SPLIT_CAR_NAME_REGEX.getRegex());
    private static final Pattern SPLIT_CAR_NAME_LENGTH_PATTERN =
            Pattern.compile(SPLIT_CAR_NAME_LENGTH_REGEX.getRegex());
    private final String delim = CARS_JOIN_DELIM.getContent();

    @Override
    public List<String> validate(List<String> splitCarName) {
        String regexErrorMessage = SPLIT_CAR_REGEX_ERROR_MESSAGE.getMessage();
        String carUniqueErrorMessage = SPLIT_CAR_UNIQUE_ERROR_MESSAGE.getMessage();

        List<String> invalidNames = checkInvalidNames(splitCarName, SPLIC_CAR_NAME_PATTERN);

        String message = String.format(regexErrorMessage,
                String.join(delim, invalidNames));

        if(!invalidNames.isEmpty()) {
            ErrorThrower.throwIAE(message);
        }
        if(splitCarName.size() != splitCarName.stream().distinct().count()) {
            ErrorThrower.throwIAE(carUniqueErrorMessage);
        }
        validateCarNameLength(splitCarName);
        return splitCarName;
    }

    private void validateCarNameLength(List<String> splitCarName) {
        List<String> invalidNames = checkInvalidNames(splitCarName, SPLIT_CAR_NAME_LENGTH_PATTERN);

        String message = String.format(SPLIT_CAR_LENGTH_ERROR_MESSAGE.getMessage(),
                String.join(delim, invalidNames));

        if (!invalidNames.isEmpty()) {
            ErrorThrower.throwIAE(message);
        }
    }

    private List<String> checkInvalidNames(List<String> splitCarName, Pattern pattern) {
        return splitCarName
                .stream()
                .filter(name -> PatternChecker.checkPattern(pattern, name))
                .collect(Collectors.toList());
    }
}