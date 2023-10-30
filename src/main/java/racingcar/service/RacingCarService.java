package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
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

    public void outputResultMessage() {
        outputView.outputLineBreak();
        outputView.outputResultMessage();
    }

    public void outputMoveResult() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.getCar(i);
            outputView.outputResult(car.getName(), car.getDistance());
        }
    }
}
