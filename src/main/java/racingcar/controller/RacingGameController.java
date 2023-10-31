package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.domain.RacingCarsResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RacingCars racingCars;

    public RacingGameController(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void start() {
        initializeGame();
        int n = getChanceNumber();
        playRacingGame(n);
        displayWinners();
    }

    private void displayWinners() {
        RacingCarsResult racingCarsResult = racingCars.getRacingCarsResult();
        OutputView.printRacingCarsWinnersMessage(racingCarsResult);
    }

    private void playRacingGame(int n) {
        OutputView.printExecutionResultMessage();
        while (n-- > 0) {
            racingCars.moveRacingCars();
            OutputView.printRacingCarsMoveMessage(racingCars);
        }
    }

    private int getChanceNumber() {
        OutputView.printInputChanceNumberMessage();
        int n = InputView.nextInt();
        return n;
    }

    private void initializeGame() {
        OutputView.printInputCarMessage();
        String racingCarsString = InputView.input();
        racingCars.generateCars(racingCarsString);
    }
}
