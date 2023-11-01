package racingcar;

import racingcar.circuit.Circuit;
import racingcar.game.RacingGame;
import racingcar.generator.NumberGenerator;
import racingcar.generator.RacingCarRandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RacingCarRandomNumberGenerator();
        Circuit circuit = new Circuit(numberGenerator);
        RacingGame racingGame = new RacingGame(circuit);
        racingGame.play();
    }
}
