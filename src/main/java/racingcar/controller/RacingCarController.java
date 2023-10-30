package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.utils.InputValidator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        List<String> carNames = inputCarNames();
        int count = inputCount();
        RacingCars racingCars = createRacingCars(carNames);

        outputView.printResultMessage();

        for (int gameCount = 0; gameCount < count; gameCount++) {
            onceRace(racingCars);
            printCarResults(racingCars.getCars());
        }

        List<String> winners = getWinners(racingCars.getCars());
        outputView.printWinner(winners);
    }

    private void onceRace(RacingCars racingCars) {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generateRandomNumber();
            moveForwardOrStop(car, randomNumber);
        }
    }

    private void printCarResults(List<Car> cars) {
        for (Car car : cars) {
            outputView.printCarResult(car.getName(), car.getPosition());
        }
    }

    private RacingCars createRacingCars(List<String> carNames) {
        InputValidator.validateMinCars(carNames);
        InputValidator.validateCarNames(carNames);
        return new RacingCars(carNames);
    }

    private List<String> inputCarNames() {
        return inputView.readCarNames();
    }

    private int inputCount() {
        return inputView.readCount();
    }

    private void moveForwardOrStop(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
        }
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }
}
