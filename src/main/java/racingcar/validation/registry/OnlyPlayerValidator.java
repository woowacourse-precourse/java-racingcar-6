package racingcar.validation.registry;

import java.util.List;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class OnlyPlayerValidator implements RegistryValidator {
    @Override
    public void validate(List<String> inputValue) {
        if (inputValue.size() == 1) {
            throw RacingCarException.of(ErrorMessage.ONLY_PLAYER);
        }
    }
}
