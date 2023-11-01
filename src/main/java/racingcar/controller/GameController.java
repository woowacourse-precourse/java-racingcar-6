package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameService gameService = new GameService();

    public void runGame(){
        String cars = inputView.inputCarNames();
        List<String> carList;
    }
}
