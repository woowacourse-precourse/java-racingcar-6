package racingcar;

import racingcar.game.GameService;
import racingcar.game.GameServiceImpl;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        gameService.playGame();
    }
}
