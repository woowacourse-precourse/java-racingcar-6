package racingcar;

import racingcar.view.Announcer;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game(
                new Announcer(),
                new CarFactory(),
                new RandomNumberGenerator(),
                new WinnerChecker(),
                new InputView());
        game.init();
        game.play();
    }
}
