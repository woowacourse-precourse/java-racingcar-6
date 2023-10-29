package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_MOVES_NUMBER = 1;

    private final List<Car> cars;

    private int movesNumber;

    public Racing() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void updateMovesNumber(int movesNumber) {
        validateMovesNumber(movesNumber);
        this.movesNumber = movesNumber;
    }

    public void generateCars(List<String> carsName) {
        carsName.forEach(this::validateCarName);
        carsName.stream()
                .map(Car::of)
                .forEach(cars::add);
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }

        if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하이어야 합니다.");
        }
    }

    private void validateMovesNumber(int movesNumber) {
        if (movesNumber < MINIMUM_MOVES_NUMBER) {
            throw new IllegalArgumentException("이동 횟수는 1회 이상이어야 합니다.");
        }
    }
}
