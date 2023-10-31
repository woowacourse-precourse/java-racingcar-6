package racingcar.model.validators;

import racingcar.Exceptions.*;

import java.util.stream.Stream;

public class CarNameValidator implements Validator<String> {

    private final String CAR_NAME_SPLIT_REGEX = ",";
    private final String CAR_NAME_SPECIAL_CHARACTER_REGEX = ".*[!@#\\$%^&*()_+\\[\\]{};':\"\\\\<>./?`~\\-=|\\s].*";
    private final int CAR_NAME_MAX_SIZE = 6;
    private final int CAR_NAME_MIN_SIZE = 0;

    @Override
    public void validate(String input) {
        validateSpecialCharacterExceptComma(input);
        validateDuplication(input);
        validateMaxLength(input);
        validateMinLength(input);
    }

    private void validateSpecialCharacterExceptComma(String input) {
        if (input.matches(CAR_NAME_SPECIAL_CHARACTER_REGEX))
            throw new CarNameSpecialCharacterException();
    }

    private void validateDuplication(String input) {
        String[] elements = input.split(CAR_NAME_SPLIT_REGEX);
        int length = elements.length;

        Stream<String> streamString = Stream.of(elements);
        int count = (int) streamString.distinct().count();

        if (length != count)
            throw new CarNameDuplicationException();
    }

    private void validateMaxLength(String input) {
        String[] elements = input.split(CAR_NAME_SPLIT_REGEX);

        Stream<String> streamString = Stream.of(elements);
        if (!streamString.allMatch(s -> s.length() < CAR_NAME_MAX_SIZE))
            throw new CarNameMaxLengthException();
    }

    private void validateMinLength(String input) {
        String[] elements = input.split(CAR_NAME_SPLIT_REGEX, -1);

        Stream<String> streamString = Stream.of(elements);
        if (!streamString.allMatch(s -> s.length() > CAR_NAME_MIN_SIZE))
            throw new CarNameMinLengthException();
    }
}
