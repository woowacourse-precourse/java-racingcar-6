package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private final int attempts;

    public Game(String carNames, String attempts) {
        this.cars = new ArrayList<>();
        String[] splitNames = carNames.split(",");
        for (String name : splitNames) {
            cars.add(new Car(name));
        }

        try {
            this.attempts = Integer.parseInt(attempts);
            if (this.attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력되어야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }
}
