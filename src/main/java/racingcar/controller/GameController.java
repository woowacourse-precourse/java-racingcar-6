package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.GameService;
import racingcar.utils.ControllerOutputManager;
import racingcar.utils.InputValidator;

public class GameController {
    static final ControllerOutputManager outputManager = new ControllerOutputManager();

    static final InputValidator inputValidator = new InputValidator();

    static final GameService gameService = new GameService();

    public void gameStart() {
        outputManager.startPrint();
        String carsNames = Console.readLine();
        String cars = inputValidator.cars(carsNames);
        outputManager.Instruction();

        String tryNum = Console.readLine();
        int number = inputValidator.number(tryNum);

        gameService.execute(cars, number);
    }

}
