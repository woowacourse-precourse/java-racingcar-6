package racingcar.validation.registry;

import java.util.List;
import racingcar.validation.ErrorMessage;

public class MaximumLengthValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (CountValueOverFive(inputValue) != 0) {
            throw new IllegalArgumentException(ErrorMessage.MAXIMUM_NAME_LENGTH.getMessage());
        }
    }

    private static int CountValueOverFive(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(name -> name.length() > 5)
                .count();
    }
}
