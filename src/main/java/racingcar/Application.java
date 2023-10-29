package racingcar;

import Controller.GameController;
import Model.CarList;
import Model.TryCount;
import View.GameView;

public class Application {
    public static void main(String[] args) {
        CarList carList = new CarList();
        TryCount tryCount = new TryCount();
        GameController controller = new GameController(carList, tryCount);

        controller.startRacingGame();
    }
}
