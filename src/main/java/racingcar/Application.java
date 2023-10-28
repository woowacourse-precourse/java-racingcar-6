package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;
import racingcar.domain.Turn;

public class Application {
    public static void main(String[] args) {
        RacingCarInputManager inputManager = new RacingCarInputManager(new RacingCarOutputManager());

        Cars cars = new Cars(inputManager.readCarNames());

        Turn turn = new Turn(inputManager.readTryToMoveTurnCount());
    }
}
