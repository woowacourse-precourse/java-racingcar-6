package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.validator.CarNamesValidator;
import racingcar.domain.validator.RoundNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView(new RoundNumberValidator(), new CarNamesValidator());
        OutputView outputView = new OutputView();
        RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        racingGameController.runRacingGame();
    }
}
