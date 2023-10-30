package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarsGenerator;

public class Application {

    public static void main(String[] args) {
        GameController controller = new GameController(new CarsGenerator());
        controller.play();
    }

}
