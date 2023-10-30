package racingcar.model;

import java.util.List;

public class RacingCarGame implements Game {
    private static final int criterion = 4;
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
}
