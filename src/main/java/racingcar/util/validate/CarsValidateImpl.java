package racingcar.util.validate;

import java.util.Arrays;
import java.util.Optional;
import racingcar.message.ErrorMessages;

public final class CarsValidateImpl implements CarsValidate {
    private CarsValidateImpl(String[] input) {
        validateDuplicatedName(input);
    }

    public static CarsValidateImpl createValue(String[] input) {
        return new CarsValidateImpl(input);
    }

    @Override
    public boolean validateDuplicatedName(String[] input) {
        long distinctSize = Arrays.stream(input)
                .distinct()
                .count();
        Optional.of(input)
                .filter(names -> distinctSize != names.length)
                .ifPresent(names -> {
                    throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME.getMessage());
                });
        return true;
    }
}

