package racingcar.validation.registry;

import java.util.Collections;
import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class DuplicateNameValidator implements RegistryValidator {
    @Override
    public void validate(List<String> inputValue) {
        if (CountDuplicateName(inputValue) != 0) {
            throw RacingCarException.of(ErrorMessage.DUPLICATED_NAME);
        }
    }

    private static int CountDuplicateName(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(i -> Collections.frequency(inputValue, i) > 1)
                .count();
    }
}
