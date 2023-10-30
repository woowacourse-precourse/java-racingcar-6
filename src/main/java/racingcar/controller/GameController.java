package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;

import static racingcar.domain.Message.*;
import static racingcar.view.OutputView.print;
import static racingcar.view.OutputView.println;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void play() {
        init();
        progressGame();
        finishGame();
    }

    private void init() {
        readCarNameList();
        readProgressCount();
    }

    private void readCarNameList() {
        println(READ_CAR_NAME.getMessage());
        gameService.addCarName(InputView.readCarNameList());
    }

    private void readProgressCount() {
        println(READ_PROGRESS_COUNT.getMessage());
        gameService.setProgressCount(InputView.readProgressCount());
    }

    private void progressGame() {
        print(PROGRESS_RESULT.getProgressMessage(gameService.createProgressResult()));
    }

    private void finishGame() {
        print(GAME_TOTAL_RESULT.getWinnerMessage(gameService.createWinnerCarNameList()));
    }
}
