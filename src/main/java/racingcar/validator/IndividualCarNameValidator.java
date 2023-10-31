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

        List<String> invalidNames = splitCarName
                .stream()
                .filter(name -> !SPLIC_CAR_NAME_PATTERN.matcher(name).matches())
                .collect(Collectors.toList());

        if(!invalidNames.isEmpty()) {
            throw new IllegalArgumentException(String.format(regexErrorMessage,
                    String.join(delim, invalidNames)));
        }
        if(splitCarName.size() != splitCarName.stream().distinct().count()) {
            throw new IllegalArgumentException(carUniqueErrorMessage);
        }
        validateCarNameLength(splitCarName);
        return splitCarName;
    }

    private void validateCarNameLength(List<String> splitCarName) {
        List<String> invalidNames = splitCarName
                .stream()
                .filter(name -> !SPLIT_CAR_NAME_LENGTH_PATTERN.matcher(name).matches())
                .collect(Collectors.toList());

        if (!invalidNames.isEmpty()) {
            throw new IllegalArgumentException(String.format(SPLIT_CAR_LENGTH_ERROR_MESSAGE.getMessage(),
                    String.join(delim, invalidNames)));
        }
    }
}