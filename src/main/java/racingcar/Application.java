package racingcar;

import racingcar.games.racing.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        Game game = new RacingController();
        game.execute();
    }
}
