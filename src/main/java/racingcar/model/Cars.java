package racingcar.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final int MAX_SIZE = 5;
    private final List<String> carNames;

    public Cars(List<String> carNames) {
        checkNameLength();
        checkDuplicate();
        this.carNames = carNames;
    }

    private void checkNameLength() {
        carNames.stream().filter(carName -> carName.length() > MAX_SIZE).forEach(carName -> {
            throw new IllegalArgumentException("자동차의 이름은 " + MAX_SIZE + "보다 작아야 합니다.");
        });
    }

    private void checkDuplicate() {
        Set<String> carNamesSet = new HashSet<>(carNames);
        if (carNames.size() != carNamesSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재 합니다.");
        }
    }
}
