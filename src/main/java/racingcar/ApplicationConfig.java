package racingcar;

import racingcar.controllers.RaceController;
import racingcar.models.RaceService;
import racingcar.views.InputView;
import racingcar.views.OutputView;

public class ApplicationConfig {
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public RaceService raceService() {
        return new RaceService();
    }

    public RaceController raceController() {
        return new RaceController(inputView(), outputView(), raceService());
    }
}
