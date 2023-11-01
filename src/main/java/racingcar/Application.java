package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RaceController raceController = new RaceController(
                new InputView(),
                new OutputView(),
                new RaceService()
        );
        raceController.run();
    }
}
