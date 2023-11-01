package racingcar;

import racingcar.controller.Game;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String[] carNames = Input.getCarNames();
        int tryCount = Input.getTryCount();

        Game game = new Game(carNames);

        for (int i = 0; i < tryCount; i++) {
            game.start();
            Output.printRaceState(game.getCars());
        }

        Output.printWinners(game.getWinners());
    }
}
