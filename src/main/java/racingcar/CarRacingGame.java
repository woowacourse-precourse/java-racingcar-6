package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRacingGame {

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String carNames = inputView.readCarNames();
        RacingCars racingCars = new RacingCars(carNames);
        String inputNumberOfAttempts = inputView.readNumberOfAttempts();
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(inputNumberOfAttempts);
        play(racingCars, numberOfAttempts.getNumberOfAttempts());
    }

    private void play(RacingCars racingCars, Integer numberOfAttempts) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numberOfAttempts; i++) {
            racingCars.race();
            resultBuilder.append(racingCars).append(System.lineSeparator()).append(System.lineSeparator());
        }
        outputView.printResult(resultBuilder);
        List<String> winnerNames = racingCars.getWinnerNames();
        outputView.printWinners(winnerNames);
    }

}
