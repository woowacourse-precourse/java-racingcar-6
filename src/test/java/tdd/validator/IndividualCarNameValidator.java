package tdd.validator;

import static tdd.config.ErrorMessage.SPLIT_CAR_LENGTH_ERROR_MESSAGE;
import static tdd.config.InputPattern.SPLIT_CAR_NAME_LENGTH_REGEX;
import static tdd.config.InputPattern.SPLIT_CAR_NAME_REGEX;
import static tdd.config.ErrorMessage.SPLIT_CAR_REGEX_ERROR_MESSAGE;
import static tdd.config.ErrorMessage.SPLIT_CAR_UNIQUE_ERROR_MESSAGE;
import static tdd.config.RacingConfig.ERROR_CARS_MESSAGE_JOIN_DELIM;

import java.util.List;
import java.util.stream.Collectors;

public class IndividualCarNameValidator implements Validator<List<String>> {
    private final String delim = ERROR_CARS_MESSAGE_JOIN_DELIM.getContent();
    @Override
    public List<String> validate(List<String> splitCarName) {
        String regex = SPLIT_CAR_NAME_REGEX.getRegex();
        String regexErrorMessage = SPLIT_CAR_REGEX_ERROR_MESSAGE.getMessage();
        String carUniqueErrorMessage = SPLIT_CAR_UNIQUE_ERROR_MESSAGE.getMessage();

        List<String> invalidNames = splitCarName
                .stream()
                .filter(name -> !name.matches(regex))
                .collect(Collectors.toList());

        if(!invalidNames.isEmpty()) {
            throw new IllegalArgumentException(String.format(regexErrorMessage,
                    String.join(delim, invalidNames)));
        }
        if(splitCarName.size() != splitCarName.stream().distinct().count()) {
            throw new IllegalArgumentException(carUniqueErrorMessage);
        }
        lengthTest(splitCarName);
        return splitCarName;
    }

    void lengthTest(List<String> splitCarName) {
        String regex = SPLIT_CAR_NAME_LENGTH_REGEX.getRegex();

        List<String> invalidNames = splitCarName
                .stream()
                .filter(name -> !name.matches(regex))
                .collect(Collectors.toList());

        if (!invalidNames.isEmpty()) {
            throw new IllegalArgumentException(String.format(SPLIT_CAR_LENGTH_ERROR_MESSAGE.getMessage(),
                    String.join(delim, invalidNames)));
        }
    }
}