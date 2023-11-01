package racingcar.game;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.model.Cars;

public class GameController {
    private final Input input;
    private final Output output;
    private final GameService gameService;

    public GameController(Input input, Output output, GameService gameService) {
        this.input = input;
        this.output = output;
        this.gameService = gameService;
    }

    public void play() {
        Cars cars = input.readCars();
        Integer rounds = input.readRounds();

        System.out.println("실행 결과");
        for (int round = 1; round <= rounds; round++) {
            gameService.playRound(cars);
            output.printResult(cars);
        }
        output.printWinner(cars);
    }
}