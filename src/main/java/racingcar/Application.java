package racingcar;

import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        RaceGame game = new RaceGame(outputView);
        game.start();
    }
}
