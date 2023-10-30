package racingcar.validation.registry;

import java.util.Collections;
import java.util.List;
import racingcar.validation.ErrorMessage;

public class DuplicateNameValidator implements RegistryValidator{
    @Override
    public void validate(List<String> inputValue) {
        if (CountDuplicateName(inputValue) != 0) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
        }
    }

    private static int CountDuplicateName(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(i -> Collections.frequency(inputValue,i) > 1)
                .count();

    }
}
