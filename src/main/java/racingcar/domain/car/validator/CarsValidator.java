package racingcar.domain.car.validator;

import java.util.List;
import racingcar.exception.car.DuplicateCarNameException;
import racingcar.exception.car.NoCarsException;

public final class CarsValidator {

    private CarsValidator() {
    }

    public static void validateCarsCount(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new NoCarsException();
        }
    }

    public static void validateDuplicateCarNames(final List<String> carNames) {
        final int uniqueCarsSize = (int) carNames.stream().distinct().count();
        final boolean hasDuplicateCarName = uniqueCarsSize != carNames.size();

        if (hasDuplicateCarName) {
            throw new DuplicateCarNameException();
        }

    }
}
