package racingcar.controller;

import static racingcar.util.Constants.ONE;

import racingcar.model.Car;
import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.model.RandomGenerator;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private TryCount tryCount;

    public CarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        initializeGame();
        startRace();
        endRace();
    }

    private void initializeGame() {
        inputCarNames();
        inputTryCount();
    }

    private void inputCarNames() {
        cars = new Cars(inputView.getPlayerNamesInput());
    }

    private void inputTryCount() {
        tryCount = new TryCount(inputView.inputTryCount());
        if (tryCount.isNotValid()) {
            inputTryCount();
        }
    }

    private void startRace() {
        outputView.printStartMessage();
        executeRounds(0);
    }

    private void executeRounds(int currentRound) {
        if (tryCount.isNotSame(currentRound)) {
            return;
        }
        executeSingleRound();
        executeRounds(currentRound + ONE);
    }

    private void executeSingleRound() {
        cars.moveAll();
        printCarStatuses();
    }

    private void printCarStatuses() {
        cars.getCars().forEach(this::printCarStatus);
    }

    private void printCarStatus(Car car) {
        CarDto carDto = CarDto.convertToDto(car);
        outputView.printCarStatus(carDto);
    }

    private void endRace() {
        printFinalCarStatuses();
        printWinners();
    }

    private void printFinalCarStatuses() {
        cars.getCars().stream()
                .map(CarDto::convertToDto)
                .forEach(outputView::printCarStatus);
    }

    private void printWinners() {
        outputView.printWinners(cars.getWinners().getWinnerNames());
    }
}
