package racingcar.controller;

import racingcar.domain.CarNameList;
import racingcar.domain.RacingCarManager;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        outputView.askToInsertCarNameList();
        CarNameList carNameList = inputView.getCarNameListFromUser();
        RacingCarManager racingCarManager = new RacingCarManager(carNameList);
        outputView.askToInsertNumberOfGames();
        Long l = inputView.getNumberOfGamesFromUser();
    }
}