package racingcar;

import static racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATED;
import static racingcar.constant.ErrorMessage.NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS;
import static racingcar.constant.ErrorMessage.NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS;

import java.util.Arrays;
import java.util.List;

public class CarRacingGame {

    private static final Integer MINIMUM_NUMBER_OF_CAR_NAMES = 2;
    private static final Integer MINIMUM_NUMBER_OF_ATTEMPTS = 1;

    private final InputView inputView;
    private final OutputView outputView;

    public CarRacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String[] carNames = inputView.readCarNames();
        validateCarNameDuplicate(carNames);
        validateNumberOfCarNames(carNames);
        RacingCars racingCars = RacingCars.from(carNames);
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

    private void validateCarNameDuplicate(String[] carNames) {
        if (Arrays.stream(carNames).distinct().count() != carNames.length) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

    private void validateNumberOfCarNames(String[] carNames) {
        if (carNames.length < MINIMUM_NUMBER_OF_CAR_NAMES) {
            throw new IllegalArgumentException(NUMBER_OF_CAR_NAME_IS_ONE_OR_LESS);
        }
    }

    private void validateNumberOfAttemptsIsOneOrLess(Integer numberOfAttempts) {
        if (numberOfAttempts < MINIMUM_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(NUMBER_OF_ATTEMPTS_IS_ZERO_OR_LESS);
        }
    }

}
