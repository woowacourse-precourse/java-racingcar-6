package racingcar;

import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(
                new RaceService(), new InputView(new Validator()), new OutputView());
        
        raceController.race();
    }
}
