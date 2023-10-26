package racingcar.model;

import java.util.List;

public class Cars {
    private static final int MAX_SIZE = 5;
    private final List<String> carNames;

    public Cars(List<String> carNames) {
        checkNameLength();
        this.carNames = carNames;
    }

    private void checkNameLength() {
        carNames.stream().filter(carName -> carName.length() > MAX_SIZE).forEach(carName -> {
            throw new IllegalArgumentException("자동차의 이름은 " + MAX_SIZE + "보다 작아야합니다.");
        });
    }

}
