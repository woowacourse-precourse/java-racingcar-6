package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.model.Cars;
import racingcar.domain.service.RacingCarRandomGenerator;
import racingcar.domain.service.RacingGame;
import racingcar.domain.service.RandomMoveJudicator;
import racingcar.view.ConsoleProvider;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // View 객체 생성
        InputView inputView = new InputView(new ConsoleProvider());
        OutputView outputView = new OutputView();

        RacingGameController racingGameController = new RacingGameController(inputView, outputView);

        racingGameController.playGame();
    }
}
