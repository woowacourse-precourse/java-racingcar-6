package racingcar;

import racingcar.service.GameService;
import racingcar.service.InputService;
import racingcar.service.PrintService;

public class GameController {
    private final PrintService print = new PrintService();
    private final InputService inputService = new InputService();
    private final GameService gameService = new GameService();

    public void start() {
        print.questionCarName();
        inputService.carsName(inputService.input());

        print.questionTryNum();
        inputService.gameNum(inputService.input());
        print.result();
        gameService.run();
    }
}