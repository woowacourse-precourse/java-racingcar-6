package racingcar;

import racingcar.controller.RacingController;
import racingcar.utils.CarListCreator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController();
        racingController.play(CarListCreator.generateCarListFromInput());
    }
}
