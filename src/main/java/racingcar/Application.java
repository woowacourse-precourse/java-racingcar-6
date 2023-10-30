package racingcar;

import racingcar.domain.CarRacing;
import racingcar.domain.RacingCarInputManager;
import racingcar.domain.RacingCarOutputManager;
import racingcar.domain.Referee;

public class Application {
    public static void main(String[] args) {
        RacingCarOutputManager outputManager = new RacingCarOutputManager();
        RacingCarInputManager inputManager = new RacingCarInputManager(outputManager);
        Referee referee = new Referee();

        CarRacing carRacing = CarRacing.init(referee, inputManager, outputManager);
        carRacing.start();
    }
}
