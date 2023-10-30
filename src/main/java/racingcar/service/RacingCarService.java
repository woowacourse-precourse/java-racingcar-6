package racingcar.service;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingCarService {

    private final InputView inputView = new InputView();
    private Cars cars;

    public void createCars() {
        String carsName = inputView.inputCars();
        cars = new Cars(carsName);
    }

    public int inputAttemptNumber() {
        return Integer.parseInt(inputView.inputAttemptNumber());
    }
}
