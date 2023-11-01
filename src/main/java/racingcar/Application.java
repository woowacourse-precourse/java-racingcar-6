package racingcar;

import racingcar.controller.CarRaceController;
import racingcar.model.CarRaceModel;
import racingcar.view.CarRaceView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarRaceModel model = new CarRaceModel();
        CarRaceView view = new CarRaceView();
        CarRaceController controller = new CarRaceController(model, view);

        controller.runGame();
    }
}

