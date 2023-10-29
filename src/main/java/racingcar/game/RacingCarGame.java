package racingcar.game;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    public static final int CAR_NAME_MAXIMUM_LENGTH = 5;

    private List<Car> cars;

    public void start() {
        OutputView.printStartMessage();
        List<String> carsName = InputView.enterCarsName();
        carsName.forEach(this::validateCarName);
        cars = generateCars(carsName);
    }

    private List<Car> generateCars(List<String> carsName) {
        return carsName.stream()
                .map(Car::of)
                .toList();
    }

    private void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > CAR_NAME_MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하이어야 합니다.");
        }
    }
}
