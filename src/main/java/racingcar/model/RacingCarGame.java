package racingcar.model;

import java.util.List;

public class RacingCarGame implements Game {
    private static final int criterion = 4;
    private static final int carNameLength = 5;
    private int attempts;
    private final List<Car> carList;

    public void goAhead(Car car, int randomNumber) {
        if (randomNumber >= criterion) {
            car.move();
        }
    }

    public void validateAttempts(String attempts) {
        try {
            this.attempts = Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수를 입력해주세요.", e);
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > carNameLength) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
