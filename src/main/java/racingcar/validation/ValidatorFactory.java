package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class ValidatorFactory {

    private static ValidatorFactory validatorFactory;
    private final Set<Validator> validators = new HashSet<>();

    private ValidatorFactory() {
    }

    public static ValidatorFactory buildDefaultValidatorFactory() {
        if (validatorFactory != null) {
            return validatorFactory;
        }
        validatorFactory = new ValidatorFactory();
        validatorFactory.registerValidator(new CarValidator());
        validatorFactory.registerValidator(new RoundValidator());
        validatorFactory.registerValidator(new RacerValidator());
        return validatorFactory;
    }

    private void registerValidator(Validator validator) {
        validators.add(validator);
    }

    public Validator getValidator(Class<?> clazz) {
        for (Validator validator : validators) {
            if (validator.support(clazz)) {
                return validator;
            }
        }
        throw new IllegalArgumentException();
    }
}
