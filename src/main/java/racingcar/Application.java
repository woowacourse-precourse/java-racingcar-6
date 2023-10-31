package racingcar;

import racingcar.controller.GameController;
import racingcar.service.ConsolePrintServiceImpl;
import racingcar.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsolePrintServiceImpl printService = new ConsolePrintServiceImpl();
        GameController gameController = new GameController(new GameService(printService), printService);

        gameController.startGame();
    }
}
