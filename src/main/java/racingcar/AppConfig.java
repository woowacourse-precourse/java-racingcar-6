package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.validator.CarValidator;
import racingcar.validator.TotalRoundValidator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    public RacingcarController racingcarController() {
        return new RacingcarController(inputView(), outputView());
    }

    public Validator carValidator() {
        return new CarValidator();
    }

    public Validator totalRoundValidator() {
        return new TotalRoundValidator();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
