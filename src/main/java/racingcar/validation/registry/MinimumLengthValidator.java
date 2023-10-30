package racingcar.validation.registry;

import java.util.List;
import racingcar.validation.ErrorMessage;

public class MinimumLengthValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (CountValueUnderOne(inputValue) != 0) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_NAME_LENGTH.getMessage());
        }
    }

    private static int CountValueUnderOne(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(String::isEmpty)
                .count();
    }

}
