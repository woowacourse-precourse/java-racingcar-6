package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RaceController raceController = new RaceController(new OutputView());
        raceController.run();
    }
}
