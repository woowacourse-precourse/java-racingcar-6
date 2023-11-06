package racingcar;

import racingcar.view.GameScreen;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        CarRacingGameMachine carRacingGameMachine = new CarRacingGameMachine(
            new InputView(), new GameScreen());
        carRacingGameMachine.start();
    }
}
