package racingcar.controller;

import racingcar.domain.CarNameList;
import racingcar.domain.RacingCarManager;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        outputView = new OutputView();
    }

    public void playGame() {
        outputView.askToInsertCarNameList();
        CarNameList carNameList = inputView.getCarNameListFromUser();
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);
        outputView.askToInsertNumberOfGames();
        Long l = inputView.getNumberOfGamesFromUser();
        outputView.printExecutionStartSign();
        for (long i = 0; i < l; i++) {
            racingCarManager.playRacingGame();
            outputView.printCarStatus(racingCarManager.getCarList());
        }
    }
}