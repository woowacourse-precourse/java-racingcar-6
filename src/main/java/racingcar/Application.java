package racingcar;

import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        GameService game = new GameService();
        game.playGame();
    }
}
