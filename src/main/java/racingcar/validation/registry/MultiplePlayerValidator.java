package racingcar.validation.registry;

import java.util.List;
import racingcar.validation.ErrorMessage;

public class MultiplePlayerValidator implements RegistryValidator{
    @Override
    public void validate(List<String> inputValue) {
        if (inputValue.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_PLAYER.getMessage());
        }
    }
}
