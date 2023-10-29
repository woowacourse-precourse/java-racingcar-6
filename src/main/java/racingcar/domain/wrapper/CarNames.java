package racingcar.domain.wrapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.handler.ErrorHandler.*;

public class CarNames {

    private final List<String> carNames;

    private CarNames(List<String> carNames) {
        validateDuplicate(carNames);

        this.carNames = carNames;
    }

    public static CarNames create(List<String> carNames) {
        return new CarNames(carNames);
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> uniqueCarName = new HashSet<>(carNames);

        if (uniqueCarName.size() != carNames.size()) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    public List<String> getCarNames() {
        return List.copyOf(carNames);
    }
}
