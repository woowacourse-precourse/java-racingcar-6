package racingcar.controller;

import java.util.List;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/*
 *  사용자와 RacingCar게임간의 흐름을 담당
 * */

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        start();
    }

    private void start() {
        outputView.requestCarName();
        List<String> carNames = inputView.carNames();
        System.out.println(carNames);
    }
}
