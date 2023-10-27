package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.COMMA;

public class MessageReceiver {

    public String[] receiveCarNames() {
        String inputText = Console.readLine();
        String[] carNames = inputText.split(COMMA);
        validateCarName(carNames);

        return carNames;
    }

    public int receiveAttemptCount() {
        String inputText = Console.readLine();
        int attemptCount = Integer.parseInt(inputText);
        validateAttemptCount(attemptCount);

        return attemptCount;
    }

    private void validateCarName(final String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateAttemptCount(final int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
