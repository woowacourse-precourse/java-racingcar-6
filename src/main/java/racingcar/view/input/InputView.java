package racingcar.view.input;

import racingcar.exception.ExceptionMessages;
import racingcar.exception.RacingCarException;

public abstract class InputView {
    abstract String read();

    public String readCarNames() {
        final String carNames = read();
        return carNames;
    }

    public int readTryCount() {
        final String tryCount = read();
        try {
            final int tryCountConvertedToInt = Integer.parseInt(tryCount);
            return tryCountConvertedToInt;
        } catch (NumberFormatException exception) {
            throw RacingCarException.of(ExceptionMessages.INPUT_ONLY_NUMBERS);
        }
    }
}
