package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.Message;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private int count;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        cars = new Cars(generateRacersFromNames(inputView.readCarNames()));
        count = inputView.readTryGame();
        startRace();
    }

    public void startRace() {
        Message.result();
        for (int i = 1; i <= count; i++) {
            cars.moveCars();
            printCarInfo(cars.getCars());
            Message.insertSpace();
        }
        findWinners(cars);
    }

    private void printCarInfo(List<Car> cars) {
        for (Car car : cars) {
            outputView.printInfo(car.getName(), car.getPosition());
        }
    }

    private void findWinners(Cars cars) {
        List<String> winners = cars.findWinners();
        outputView.racingWinners(winners);
    }

    private String[] generateRacersFromNames(String input) {
        return input.split(",");
    }

}
