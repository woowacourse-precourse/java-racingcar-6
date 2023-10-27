package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.NumberConstant.MAX_CAR_NAME_SIZE;
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
        return Integer.parseInt(inputText);
    }

    private void validateCarName(final String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }
}
