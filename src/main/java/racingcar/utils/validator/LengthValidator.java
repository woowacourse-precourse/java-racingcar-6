package racingcar.utils.validator;

import java.util.List;

public class LengthValidator {
    public static boolean validate(List<String> inputs, int maxLength) {
        return inputs.stream()
                .allMatch(input -> input.length() <= maxLength);
    }
}
