package racingcar;

import racingcar.domain.CarRacing;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;

public class Application {
    public static void main(String[] args) {
        RacingCarOutputManager outputManager = new RacingCarOutputManager();
        RacingCarInputManager inputManager = new RacingCarInputManager(outputManager);
        CarRacing carRacing = CarRacing.init(inputManager, outputManager);

        carRacing.start();
    }
}
