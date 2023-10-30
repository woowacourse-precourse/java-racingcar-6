package racingcar.controller;

import racingcar.service.GameService;
import racingcar.utils.ControllerOutputManager;
import racingcar.utils.InputManager;

public class GameController {
    static final ControllerOutputManager outputManager = new ControllerOutputManager();

    static final InputManager inputManager = new InputManager();

    static final GameService gameService = new GameService();

    public void gameStart() {
        outputManager.startPrint();
        String cars = inputManager.cars();
        outputManager.Instruction();
        int number = inputManager.number();

        gameService.execute(cars, number);
    }

}
