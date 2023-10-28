package racingcar;

import controller.RacingCarController;
import util.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarController racingCarController = new RacingCarController();

        View.printStartMessage();
        racingCarController.extractName(View.input());
        View.printCycleInputMessage();
        racingCarController.startRacing(View.input());
        racingCarController.showResult();
    }
}
