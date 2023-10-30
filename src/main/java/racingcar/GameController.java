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
        String input = inputService.init();
        inputService.carNames(input);

        print.questionTryNum();
        input = inputService.init();
        inputService.numOfAttempts(input);
        gameService.run(inputService.findGameNum(), inputService.findCars());
    }
}