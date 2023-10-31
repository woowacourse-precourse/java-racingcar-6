package racingcar.controller;

import racingcar.dto.AttemptCount;
import racingcar.dto.CarsState;
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
        generateCars();
        attemptForward(setAttemptCount());
        printWinners();
    }

    private void generateCars() {
        view.printNameInputMessage();
        gamePlayingService.generateCars(readFromConsole());
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

    private void attemptForward(int count) {
        view.printAttemptResultMessage();

        for (int current = 0; current < count; current++) {
            gamePlayingService.tryForward();
            view.printCurrentCarsState(getCarsState());
        }
    }

    private CarsState getCarsState() {
        return gamePlayingService.getCarsState();
    }

    private void printWinners() {
        view.printFinalWinnerMessage(getWinners());
    }

    private Winners getWinners() {
        return gamePlayingService.getWinners();
    }
}