package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    InputView inputView = new InputView();
    RacingCarService service = new RacingCarService();

    public String userInputCarName() {
        return inputView.getUserInput();
    }

    public String userInputTryNumber() {
        return inputView.getUserInput();
    }

    public void racingCar() {
        Map<String, List<String>> result = service.translateResult(userInputCarName(), userInputTryNumber());
        OutputView.racingResultMessage(result);
    }


}
