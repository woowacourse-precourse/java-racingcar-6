package racingcar.validation;

import java.util.List;
import racingcar.validation.registry.DuplicateNameValidator;
import racingcar.validation.registry.EmptyInputValidator;
import racingcar.validation.registry.MaximumLengthValidator;
import racingcar.validation.registry.MinimumLengthValidator;
import racingcar.validation.registry.MultiplePlayerValidator;
import racingcar.validation.registry.RegistryValidator;

public class Registry {
    private static final RegistryValidator[] registryValidator = {
            new EmptyInputValidator(),
            new MultiplePlayerValidator(),
            new DuplicateNameValidator(),
            new MinimumLengthValidator(),
            new MaximumLengthValidator()
    };

    public static void isValid(List<String> inputValue) {
        for(RegistryValidator validator: registryValidator){
            validator.validate(inputValue);
        }
    }

}
