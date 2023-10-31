package racingcar.controller;

import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.service.GamePlayingService;
import racingcar.view.View;

public class Controller {
    private final View view;
    private final GamePlayingService gamePlayingService;

    public Controller(View view, GamePlayingService gamePlayingService) {
        this.view = view;
        this.gamePlayingService = gamePlayingService;
    }

    public void start() {
        Cars cars = generateCars();
        attemptForward(cars, setAttemptCount());
        printWinners(cars);
    }

    private Cars generateCars() {
        view.printNameInputMessage();
        return gamePlayingService.generateCars(readFromConsole());
    }

    private String readFromConsole() {
        return view.inputConsole();
    }

    private int setAttemptCount() {
        view.printAttemptCountInputMessage();
        return getCount(gamePlayingService.createAttemptCount(readFromConsole()));
    }

    private int getCount(AttemptCount attemptCount) {
        return attemptCount.count();
    }

    private void attemptForward(Cars cars, int count) {
        view.printAttemptResultMessage();

        for (int current = 0; current < count; current++) {
            gamePlayingService.tryForward(cars);
            view.printCurrentCarsState(getCarsState(cars));
        }
    }

    private CarsState getCarsState(Cars cars) {
        return gamePlayingService.getCarsState(cars);
    }

    private void printWinners(Cars cars) {
        view.printFinalWinnerMessage(getWinners(cars));
    }

    private Winners getWinners(Cars cars) {
        return gamePlayingService.getWinners(cars);
    }
}