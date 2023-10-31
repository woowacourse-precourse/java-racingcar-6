package racingcar;

import racingcar.domain.GameService;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.playGame();
    }

}
