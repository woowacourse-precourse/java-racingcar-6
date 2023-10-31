package racingcar.controller;

import racingcar.dto.TotalResult;
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
        setAttemptCount();
        playRounds();
        printWinners();
    }

    private void generateCars() {
        view.printNameInputMessage();
        gamePlayingService.generateCars(readFromConsole());
    }

    private String readFromConsole() {
        return view.inputConsole();
    }

    private void setAttemptCount() {
        view.printAttemptCountInputMessage();
        gamePlayingService.setAttemptCount(readFromConsole());
    }

    private void playRounds() {
        printTotalResult(gamePlayingService.playRounds());
    }

    private void printTotalResult(TotalResult totalResult) {
        view.printTotalResult(totalResult);
    }

    private void printWinners() {
        view.printFinalWinnerMessage(getWinners());
    }

    private Winners getWinners() {
        return gamePlayingService.getWinners();
    }
}