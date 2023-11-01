package racingcar.controller;

import java.util.Arrays;

public final class InputValidator implements FrontValidator {

    public void validateSingleNumber(String givenInput) {
        try {
            Integer.parseInt(givenInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자가 아닙니다.");
        }
    }

    public void validateNamesByDelimiter(String givenInput, String delimiter) {
        Arrays.asList(givenInput.split(delimiter))
                .forEach(part -> {
                    if (checkMatches(part)) {
                        throw new IllegalArgumentException("delimiter를 제외한 부분에 특수 문자가 포함되어 있습니다.");
                    }
                });
    }

    private boolean checkMatches(String part) {
        return !part.matches("[a-zA-Z가-힣]+");
    }
}
