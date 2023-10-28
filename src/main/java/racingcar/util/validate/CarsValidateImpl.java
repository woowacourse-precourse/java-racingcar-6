package racingcar.util.validate;

import java.util.Arrays;
import java.util.Optional;

public class CarsValidateImpl implements CarsValidate {

    public CarsValidateImpl(String[] input) {
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
                    throw new IllegalArgumentException("중복!");
                });
        return true;
    }
}

