package racingcar;

import racingcar.domain.CarController;
import racingcar.domain.RacingRuleMaker;

public class Application {

    public static void main(String[] args) {
        RacingRuleMaker racingRuleMaker = new RacingRuleMaker();
        CarController carController = new CarController(racingRuleMaker.getCars());

        for (int roundCount = 0; roundCount < racingRuleMaker.getRoundCount(); roundCount++) {
            carController.gameStart();

        }

    }
}
