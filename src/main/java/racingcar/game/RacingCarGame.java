package racingcar.game;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    public void start() {
        OutputView.printStartMessage();
        List<String> carsName = InputView.enterCarsName();
        cars = generateCars(carsName);
    }

    private List<Car> generateCars(List<String> carsName) {
        return carsName.stream()
                .map(Car::of)
                .toList();
    }
}
