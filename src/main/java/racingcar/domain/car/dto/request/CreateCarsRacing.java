package racingcar.domain.car.dto.request;

import java.util.List;
import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.NoCarsException;

public record CreateCarsRacing(List<String> carNames) {

    public CreateCarsRacing {
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
