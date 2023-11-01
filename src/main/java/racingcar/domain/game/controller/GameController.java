package racingcar.domain.game.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomUtil;
import racingcar.domain.car.dto.CarsNameDto;
import racingcar.domain.game.generator.ExecutionResultGenerator;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.generator.WinningResultGenerator;
import racingcar.domain.game.dto.ExecutionCountDto;
import racingcar.global.view.input.InputView;
import racingcar.global.view.output.OutputView;

import static racingcar.global.view.output.GameMessage.*;

public class GameController {
    private RandomUtil randomUtil;
    private ExecutionResultGenerator executionResultGenerator;
    private WinningResultGenerator winningResultGenerator;
    private RacingGame racingGame;

    public GameController(RandomUtil randomUtil, ExecutionResultGenerator executionResultGenerator, WinningResultGenerator winningResultGenerator) {
        this.randomUtil = randomUtil;
        this.executionResultGenerator = executionResultGenerator;
        this.winningResultGenerator = winningResultGenerator;
        this.racingGame = new RacingGame(randomUtil);
    }

    public void playGame() {
        generateCars();
        runRace();
        printExecutionResults();
        announceWinningCars();
    }

    private void generateCars() {
        OutputView.printMessageLine(WRITE_CARS_NAME);
        CarsNameDto carsNameDto = new CarsNameDto(InputView.stringInput());
        racingGame.generateCars(carsNameDto.names());
    }

    private void runRace() {
        int executionCount = setExecutionCount();
        racingGame.startRacingGame(executionCount);

        while(racingGame.isRunning()) {
            racingGame.runRace();
            Cars cars = racingGame.getCars();
            executionResultGenerator.generateOneTurnExecutionResults(cars.getCars());
        }
    }

    public void printExecutionResults() {
        OutputView.printMessageLine(EXECUTION_RESULT);
        String result = executionResultGenerator.generateAllExecutionResults();
        OutputView.printMessage(result);
    }

    private int setExecutionCount() {
        OutputView.printMessageLine(WRITE_TRY_NUMBER);
        ExecutionCountDto executionCountDto = new ExecutionCountDto(InputView.integerInput());

        return executionCountDto.number();
    }

    private void announceWinningCars() {
        Cars cars = racingGame.getCars();
        String winningCars = winningResultGenerator.generateWinners(cars.getCars());
        OutputView.printMessage(FINAL_WINNERS);
        OutputView.printMessageLine(winningCars);
    }
}
