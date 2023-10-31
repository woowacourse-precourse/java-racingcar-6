package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCarManager;
import racingcar.validator.CarNamesInputValidator;
import racingcar.validator.NumberOfGamesInputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(new CarNamesInputValidator(), new NumberOfGamesInputValidator());
        outputView.askToInsertCarNames();
        List<String> carNames = inputView.getCarNamesFromUser();
        carNames.forEach(System.out::println);
        RacingCarManager racingCarManager = new RacingCarManager(carNames);
        outputView.askToInsertNumberOfGames();
        Long l = inputView.getNumberOfGamesFromUser();
    }
}