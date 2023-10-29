package racingcar.validation;

import static racingcar.constant.MessageConst.DUPLICATE_MESSAGE;
import static racingcar.constant.MessageConst.EMPTY_MESSAGE;
import static racingcar.constant.MessageConst.LENGTH_MESSAGE;
import static racingcar.constant.MessageConst.NULL_MESSAGE;
import static racingcar.constant.MessageConst.SPACE_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidation {

    public void validateCarNameRange(List<String> carNames) {
        for (String carName : carNames) {
            int carNameLength = carName.length();
            isRangeValid(carNameLength);
        }
    }

    public void isRangeValid(int carNameLength) {
        if (carNameLength < 1 || carNameLength > 5) {
            throw new IllegalArgumentException(LENGTH_MESSAGE);
        }
    }

    public void validateCarNameDuplication(List<String> carNames) {
        Set<String> set = new HashSet<>(carNames);
        if (set.size() < carNames.size()) {
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
        }
    }

    public void validateCarNameSpace(List<String> carNames) {
        if (hasCarNamesWithSpace(carNames)) {
            throw new IllegalArgumentException(SPACE_MESSAGE);
        }
    }

    private boolean hasCarNamesWithSpace(List<String> carNames) {
        return carNames.stream()
                .anyMatch(carName -> carName.contains(" "));
    }

    public void validateCarNameEmpty(List<String> carNames) {
        if (hasCarNamesWithEmpty(carNames)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private boolean hasCarNamesWithEmpty(List<String> carNames) {
        return carNames.stream()
                .anyMatch(carName -> carName.isEmpty());
    }

    public void validateInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
    }
}
