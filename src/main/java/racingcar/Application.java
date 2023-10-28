package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarIOManager;

public class Application {
    public static void main(String[] args) {
        RacingCarIOManager ioManager = new RacingCarIOManager();
        Cars cars = new Cars(ioManager.readCarNames());
    }
}
