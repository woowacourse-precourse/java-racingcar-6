package racingcar.validation.registry;

import java.util.List;
import racingcar.validation.ErrorMessage;

public class EmptyInputValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (isEmptyList(inputValue)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static boolean isEmptyList(List<String> inputValue) {
        return (inputValue.size() == 1 && inputValue.get(0).isEmpty());
    }
}
