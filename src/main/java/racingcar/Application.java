package racingcar;

import racingcar.domain.car.dao.CarRepository;
import racingcar.domain.car.controller.GameController;
import racingcar.domain.car.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // FIX HERE!
        GameController gameController = new GameController(new GameService(new CarRepository()));
        gameController.startGame();
        gameController.receiveTryCount();
        gameController.endGame();
    }
}
