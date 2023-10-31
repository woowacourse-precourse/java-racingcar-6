package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarRepository;
import racingcar.model.CarService;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarService model = new CarService(new CarRepository());
        GameView view = new GameView();
        GameController controller = new GameController(model, view);
        controller.run();
    }
}