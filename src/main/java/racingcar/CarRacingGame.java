package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;

import java.util.List;

public class CarRacingGame {

    private static final Integer MINIMUM_NUMBER_OF_ATTEMPTS = 1;

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String[] carNames = inputView.readCarNames();
        RacingCars racingCars = new RacingCars(carNames);
        Integer numberOfAttempts = inputView.readNumberOfAttempts();
        validateNumberOfAttemptsIsOneOrLess(numberOfAttempts);
        play(racingCars, numberOfAttempts);
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

    private void validateNumberOfAttemptsIsOneOrLess(Integer numberOfAttempts) {
        if (numberOfAttempts < MINIMUM_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS);
        }
    }

}
