package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void playGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.askToInsertCarNames();
        List<String> carNames = inputView.getCarNamesFromUser();
        carNames.forEach(System.out::println);
        outputView.askToInsertNumberOfGames();
        Integer numberOfGames = inputView.getNumberOfGamesFromUser();
        System.out.println(numberOfGames);
    }
}