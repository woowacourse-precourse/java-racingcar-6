package racingcar.validation.registry;

import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class EmptyInputValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (isEmptyList(inputValue)) {
            throw RacingCarException.of(ErrorMessage.EMPTY_INPUT);
        }
    }

    private static boolean isEmptyList(List<String> inputValue) {
        return (inputValue.size() == 1 && inputValue.get(0).isEmpty());
    }
}
