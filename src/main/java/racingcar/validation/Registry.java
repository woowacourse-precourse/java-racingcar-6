package racingcar.validation;

import java.util.List;
import racingcar.validation.registry.DuplicateNameValidator;
import racingcar.validation.registry.EmptyRegistryValidator;
import racingcar.validation.registry.MaximumLengthValidator;
import racingcar.validation.registry.MinimumLengthValidator;
import racingcar.validation.registry.OnlyPlayerValidator;
import racingcar.validation.registry.RegistryValidator;

public class Registry {
    private static final RegistryValidator[] registryValidator = {
            new EmptyRegistryValidator(),
            new OnlyPlayerValidator(),
            new DuplicateNameValidator(),
            new MinimumLengthValidator(),
            new MaximumLengthValidator()
    };

    public static void isValid(List<String> inputValue) {
        for (RegistryValidator validator : registryValidator) {
            validator.validate(inputValue);
        }
    }

}
