package racingcar.domain.car;

import java.util.List;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.NoCarsException;

public final class CarsValidator {

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
