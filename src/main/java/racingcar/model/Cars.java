package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.utils.Constraints;

public class Cars {
    private final List<String> carNames;

    public Cars(List<String> carNames) {
        checkNameLength(carNames);
        checkDuplicate(carNames);
        this.carNames = carNames;
    }

    private void checkNameLength(List<String> carNames) {
        carNames.stream()
                .filter(carName -> carName.length() > Constraints.MAX_SIZE.getValue())
                .forEach(carName -> {
                    throw new IllegalArgumentException("자동차의 이름은 " + Constraints.MAX_SIZE.getValue() + "보다 작아야 합니다.");
                });
    }

    private void checkDuplicate(List<String> carNames) {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재 합니다.");
        }
    }
}
