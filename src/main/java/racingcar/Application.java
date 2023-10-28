package racingcar;

import racingcar.circuit.Circuit;
import racingcar.game.RacingGame;
import racingcar.generator.RacingCarRandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Circuit circuit = new Circuit(new RacingCarRandomNumberGenerator());
        RacingGame racingGame = new RacingGame(inputView, outputView, circuit);
        racingGame.start();
    }
}
