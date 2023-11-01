package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingFactory racingFactory = new RacingFactory();
        final RacingController racingController = racingFactory.createRacingController();
        racingController.run();
        Console.close();
    }
}
