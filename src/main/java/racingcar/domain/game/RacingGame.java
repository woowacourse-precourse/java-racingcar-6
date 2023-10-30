package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.car.RandomUtil;
import racingcar.domain.car.dto.CarsNameDto;
import racingcar.domain.game.dto.ExecutionCountDto;
import racingcar.global.view.input.InputView;
import racingcar.global.view.output.GameMessage;
import racingcar.global.view.output.OutputView;

public class RacingGame {
    private RandomUtil randomUtil;
    private Cars cars;
    private ExecutionResultGenerator executionResultGenerator;
    private WinningResultGenerator winningResultGenerator;

    public RacingGame(RandomUtil randomUtil, ExecutionResultGenerator executionResultGenerator, WinningResultGenerator winningResultGenerator) {
        this.randomUtil = randomUtil;
        this.executionResultGenerator = executionResultGenerator;
        this.winningResultGenerator = winningResultGenerator;
    }

    public void generateCars(String carNames) {
        cars = new Cars(randomUtil, carNames);
    }

    public void runRace() {
        cars.runRace();
        executionResultGenerator.generateOneTurnExecutionResults(cars.getCars());
    }

    public String generateExecutionResult() {
        return executionResultGenerator.generateAllExecutionResults();
    }

    public String selectWinners() {
        return winningResultGenerator.generateWinningCarsResult(cars.getCars());
    }
}
