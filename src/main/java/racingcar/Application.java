package racingcar;

import racingcar.controller.RacingController;
import racingcar.utils.AttemptCountReader;
import racingcar.utils.CarNamesReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController racingController = new RacingController();
        racingController.play(CarNamesReader.get(), AttemptCountReader.get());
    }
}
