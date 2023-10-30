package racingcar.validation.registry;

import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class MaximumLengthValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (CountValueOverFive(inputValue) != 0) {
            throw RacingCarException.of(ErrorMessage.MAXIMUM_NAME_LENGTH);
        }
    }

    private static int CountValueOverFive(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(name -> name.length() > 5)
                .count();
    }
}
