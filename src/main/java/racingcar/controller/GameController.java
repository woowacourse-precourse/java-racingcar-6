package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.domain.CarNameList;
import racingcar.domain.NumberOfGames;
import racingcar.domain.RacingCarManager;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingCarManager racingCarManager;
    private NumberOfGames numberOfGames;

    public GameController() {
        inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        outputView = new OutputView();
    }

    public void playGame() {
        setUpGame();
        executeGame();
        showGameResult();
    }

    private void setUpGame() {
        initRacingCarManager();
        initNumberOfGames();
    }

    private void initRacingCarManager() {
        CarNameList carNameList = getCarNameListFromUser();
        racingCarManager = new RacingCarManager(carNameList);
    }

    private CarNameList getCarNameListFromUser() {
        outputView.askToInsertCarNameList();
        return inputView.getCarNameListFromUser();
    }

    private void initNumberOfGames() {
        numberOfGames = getNumberOfGamesFromUser();
    }

    private NumberOfGames getNumberOfGamesFromUser() {
        outputView.askToInsertNumberOfGames();
        return inputView.getNumberOfGamesFromUser();
    }

    private void executeGame() {
        printExecutionStartSign();
        for (long i = 0; i < numberOfGames.getNumberOfGames(); i++) {
            playRacingGame();
            printEachCarStatus();
        }
    }

    private void printExecutionStartSign() {
        outputView.printExecutionStartSign();
    }

    private void playRacingGame() {
        racingCarManager.playRacingGame();
    }

    private void printEachCarStatus() {
        outputView.printCarStatus(racingCarManager.getCarList());
    }

    private void showGameResult() {
        CarList mostDistanceCarList = getMostDistanceCarList();
        printFinalWinner(mostDistanceCarList);
    }

    private CarList getMostDistanceCarList() {
        return racingCarManager.getMostDistanceCarList();
    }

    private void printFinalWinner(CarList mostDistanceCarList) {
        outputView.printFinalWinner(mostDistanceCarList);
    }
}