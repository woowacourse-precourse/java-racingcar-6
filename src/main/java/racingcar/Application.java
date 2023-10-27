package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.GameController;
import racingcar.view.MainView;

public class Application {
    public static void main(String[] args) {
        MainView mainView = new MainView(new CarController(), new GameController());
        mainView.run();
    }
}
