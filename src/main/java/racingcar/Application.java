package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberPicker;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameController controller = new RacingGameController(
                new RandomNumberPicker(),
                new OutputView(),
                new InputView());
        controller.gameProcess();
    }
}
