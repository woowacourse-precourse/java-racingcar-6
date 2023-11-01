package racingcar;

import Domain.Game;
import Service.GameService;

public class Controller {
    public void run() throws IllegalArgumentException {
        GameService gameService = new GameService();
        Game game = gameService.createGame();
        gameService.runGame(game);
    }
}
