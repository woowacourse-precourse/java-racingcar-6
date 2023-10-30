package racingcar.validation;

import java.util.Set;

public class ValidatorFactory {

    private static ValidatorFactory validatorFactory;
    private final Set<Validator> validators;

    private ValidatorFactory(Set<Validator> validators) {
        validatorFactory = this;
        this.validators = validators;
    }

    public static ValidatorFactory buildDefaultValidatorFactory() {
        if (validatorFactory != null) {
            return validatorFactory;
        }
        return new ValidatorFactory(Set.of(new CarValidator(), new RacerValidator(), new RoundValidator()));
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
