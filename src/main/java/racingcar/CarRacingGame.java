package racingcar;

import racingcar.model.NumberOfAttempts;
import racingcar.model.RacingCars;
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
        final String carNames = inputView.readCarNames();
        final RacingCars racingCars = new RacingCars(carNames);
        final String inputNumberOfAttempts = inputView.readNumberOfAttempts();
        final NumberOfAttempts numberOfAttempts = new NumberOfAttempts(inputNumberOfAttempts);
        play(racingCars, numberOfAttempts.getNumberOfAttempts());
    }

    private void play(final RacingCars racingCars, final Integer numberOfAttempts) {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numberOfAttempts; i++) {
            racingCars.race();
            resultBuilder.append(racingCars).append(System.lineSeparator()).append(System.lineSeparator());
        }
        outputView.printResult(resultBuilder);
        final List<String> winnerNames = racingCars.getWinnerNames();
        outputView.printWinners(winnerNames);
    }

}
