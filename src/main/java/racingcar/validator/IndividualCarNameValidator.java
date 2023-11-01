package racingcar.validator;

import static racingcar.config.ErrorMessage.SPLIT_CAR_LENGTH_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.SPLIT_CAR_REGEX_ERROR_MESSAGE;
import static racingcar.config.ErrorMessage.SPLIT_CAR_UNIQUE_ERROR_MESSAGE;
import static racingcar.config.InputPattern.SPLIT_CAR_NAME_LENGTH_REGEX;
import static racingcar.config.InputPattern.SPLIT_CAR_NAME_REGEX;
import static racingcar.config.RacingConfig.CARS_JOIN_DELIM;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.util.ErrorThrower;
import racingcar.util.PatternChecker;

public class IndividualCarNameValidator implements Validator<List<String>> {
    private static final Pattern SPLIT_CAR_NAME_PATTERN =
            Pattern.compile(SPLIT_CAR_NAME_REGEX.getRegex());
    private static final Pattern SPLIT_CAR_NAME_LENGTH_PATTERN =
            Pattern.compile(SPLIT_CAR_NAME_LENGTH_REGEX.getRegex());
    private static final String delim = CARS_JOIN_DELIM.getContent();

    @Override
    public List<String> validate(List<String> splitCarName) {
        validateCarNamePattern(splitCarName);
        validateCarNameUnique(splitCarName);
        validateCarNameLength(splitCarName);
        return splitCarName;
    }

    private void validateCarNamePattern(List<String> splitCarName) {
        String regexErrorMessage = SPLIT_CAR_REGEX_ERROR_MESSAGE.getMessage();
        List<String> invalidNames = checkInvalidNames(splitCarName, SPLIT_CAR_NAME_PATTERN);

        throwIfInvalidNamesExist(invalidNames, regexErrorMessage);
    }

    private void validateCarNameUnique(List<String> splitCarName) {
        String carUniqueErrorMessage = SPLIT_CAR_UNIQUE_ERROR_MESSAGE.getMessage();
        Set<String> uniqueNames = new HashSet<>();
        List<String> invalidNames = new ArrayList<>();

        for (String name : splitCarName) {
            if (!uniqueNames.add(name)) {
                invalidNames.add(name);
            }
        }
        throwIfInvalidNamesExist(invalidNames, carUniqueErrorMessage);
    }

    private void validateCarNameLength(List<String> splitCarName) {
        List<String> invalidNames = checkInvalidNames(splitCarName, SPLIT_CAR_NAME_LENGTH_PATTERN);
        String carNameLengthErrorMessage = SPLIT_CAR_LENGTH_ERROR_MESSAGE.getMessage();
        throwIfInvalidNamesExist(invalidNames, carNameLengthErrorMessage);
    }

    private List<String> checkInvalidNames(List<String> splitCarName, Pattern pattern) {
        return splitCarName
                .stream()
                .filter(name -> PatternChecker.checkPattern(pattern, name))
                .toList();
    }

    private void throwIfInvalidNamesExist(List<String> invalidNames, String baseErrorMessage) {
        if (!invalidNames.isEmpty()) {
            String message = baseErrorMessage + String.join(delim, invalidNames);
            ErrorThrower.throwIAE(message);
        }
    }
}