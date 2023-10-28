package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.View;
import racingcar.service.GameService;
import racingcar.util.CarNamesSeperator;
import racingcar.util.GameTimeParser;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        gameService.enrollCars(getCarNames());
        int gameTime = getGameTime();
//
//        for (int i = 0; i < gameTime; i++) {
//            List<GameResult> gameResultList = gameService.runGame();
//            for (GameResult gameResult : gameResultList) {
//
//            }
//        }
    }

    private List<String> getCarNames() {
        String userInputCarNames = inputNames();
        return CarNamesSeperator.separate(userInputCarNames);
    }

    private int getGameTime() {
        String gameTimeInput = inputGameTime();
        return GameTimeParser.parse(gameTimeInput);
    }

    private String inputGameTime() {
        View.inputGameTime();
        return Console.readLine();
    }

    private String inputNames() {
        View.inputCarName();
        return Console.readLine();
    }

}
