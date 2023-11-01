package racingcar.controller;

import java.util.Arrays;

public final class InputValidator implements FrontValidator {
    @Override
    public void validateSingleNumber(String givenInput) {
        try {
            Integer.parseInt(givenInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_ERROR_MESSAGE);
        }
    }
    @Override
    public void validateNamesByDelimiter(String givenInput, String delimiter) {
        Arrays.asList(givenInput.split(delimiter))
                .forEach(part -> {
                    if (checkMatches(part)) {
                        throw new IllegalArgumentException(WRONG_WORDS_ERROR_MESSAGE);
                    }
                });
    }

    private boolean checkMatches(String part) {
        return !part.matches(ENG_KOREAN_WORDS_PATTERN);
    }
}
