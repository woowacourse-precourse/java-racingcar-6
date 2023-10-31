package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class StringValidator implements InputValidator {

    String input;

    public StringValidator(String input) {
        this.input = input;
    }

    private void isTokensLengthAreAvailable(List<String> tokens) {
        for (String token : tokens) {
            if (token.length() > 5) {
                throw new IllegalArgumentException("자동차명이 지정 길이를 초과합니다.");
            }
        }
    }

    @Override
    public void validate() {
        List<String> tokens = Arrays.asList(input.split(","));
        isTokensLengthAreAvailable(tokens);
    }
}
