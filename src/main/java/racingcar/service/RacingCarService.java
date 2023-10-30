package racingcar.service;

import racingcar.domain.Cars;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;

public class RacingCarService {

    private final InputView inputView = new InputView();
    private final RandomNumber randomNumber = new RandomNumber();

    private Cars cars;

    public void createCars() {
        String carsName = inputView.inputCars();
        cars = new Cars(carsName);
    }

    public int inputAttemptNumber() {
        return Integer.parseInt(inputView.inputAttemptNumber());
    }

    public void moveCars() {
        int number = generateNumber();
        cars.moveCars(number);
    }

    private int generateNumber() {
        return randomNumber.create();
    }
}
