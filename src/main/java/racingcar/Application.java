package racingcar;

import racingcar.factory.RacingCarFactory;

public class Application {
    public static void main(String[] args) {
        RacingCarFactory racingCarConfig = new RacingCarFactory();
        racingCarConfig.racingCarController().run();
    }
}
