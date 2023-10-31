package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
        Console.close();
    }
}
