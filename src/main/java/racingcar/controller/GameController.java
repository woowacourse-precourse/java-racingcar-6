package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.service.GameService;
import racingcar.view.GameInputView;
import racingcar.view.GameOutputView;

public class GameController {
    private final GameService gameService;

    public GameController() {
        this.gameService = new GameService();
    }

    public void start(){
        GameInputView.printStartMessage();
        String carNames = readLine();

        GameInputView.printTryInputMessage();
        String tryCount = readLine();

        gameService.start(carNames, tryCount);
    }
}
