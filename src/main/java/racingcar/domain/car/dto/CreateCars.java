package racingcar.domain.car.dto;

import java.util.List;
import racingcar.domain.exception.DuplicateCarNameException;
import racingcar.domain.exception.NoCarsException;

public record CreateCars(List<String> carNames) {

    public CreateCars {
        validateCarsCount(carNames);
        validateDuplicateCarNames(carNames);
    }

    private static void validateCarsCount(final List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new NoCarsException();
        }
    }

    private static void validateDuplicateCarNames(final List<String> carNames) {
        final int uniqueCarsSize = (int) carNames.stream().distinct().count();
        final boolean hasDuplicateCarName = uniqueCarsSize != carNames.size();

        if (hasDuplicateCarName) {
            throw new DuplicateCarNameException();
        }
    }
}
