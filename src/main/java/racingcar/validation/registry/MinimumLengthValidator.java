package racingcar.validation.registry;

import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class MinimumLengthValidator implements RegistryValidator {

    @Override
    public void validate(List<String> inputValue) {
        if (CountValueUnderOne(inputValue) != 0) {
            throw RacingCarException.of(ErrorMessage.MINIMUM_NAME_LENGTH);
        }
    }

    private static int CountValueUnderOne(List<String> inputValue) {
        return (int) inputValue.stream()
                .filter(String::isEmpty)
                .count();
    }

}
