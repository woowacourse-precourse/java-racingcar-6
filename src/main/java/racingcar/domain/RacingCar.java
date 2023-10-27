package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.handler.ErrorHandler.*;

public class RacingCar {

    private final List<String> carNames;

    public RacingCar(List<String> carNames) {
        validateCarNames(carNames);
        validateDuplicate(carNames);
        validateRange(carNames);

        this.carNames = carNames;
    }

    public void validateCarNames(List<String> carNames) {
        String regex = "^[a-z|A-Z|ㄱ-ㅎ|가-힣]+$";

        for (String carName : carNames) {
            if (!Pattern.matches(regex, carName)) {
                throw INVALID_ENGLISH_KOREAN.getException();
            }
        }
    }

    public void validateDuplicate(List<String> carNames) {
        Set<String> uniqueCarName = new HashSet<>(carNames);

        if (uniqueCarName.size() != carNames.size()) {
            throw DUPLICATE_NUMBER.getException();
        }
    }

    public void validateRange(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw INVALID_RANGE.getException();
            }
        }
    }

    public List<String> getCarNames() {
        return List.copyOf(carNames);
    }
}
