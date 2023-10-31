package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private static GameController INSTANCE;
    private final GameService gameService;
    private final GameView gameView;

    private GameController() {
        gameService = GameService.getInstance();
        gameView = GameView.getInstance();
    }

    public static GameController getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameController();
        }

        return INSTANCE;
    }

    public void race() {
        gameView.printCarInputMessage();
        List<Car> cars = gameService.getCars();

        gameView.printTryInputMessage();
        int tries = gameService.getTries();

        String gameResult = gameService.doTurns(cars, tries);
        gameView.printResultMessage(gameResult);

        String winners = gameService.getWinnersList(cars);
        gameView.printWinners(winners);
    }
}
