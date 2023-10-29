package racingcar.utils.validator;

import java.util.List;

public class NotEmptyValidator {

    public static boolean validate(List<String> inputs) {
        return inputs.stream()
                .noneMatch(s -> s.isEmpty());
    }
}
