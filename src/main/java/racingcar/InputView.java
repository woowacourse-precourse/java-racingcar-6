package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;


public class InputView {
    MagicVariable magicVariable = new MagicVariable();
    String userInput = Console.readLine();
    public List<String> getCarNames() {
        System.out.println(magicVariable.RACE_START_MESSAGE);
        String[] carNames = userInput.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5 || !carName.matches(magicVariable.CAR_NAME_RULE)) {
                throw new IllegalArgumentException(magicVariable.CAR_NAME_ERROR_MESSAGE);
            }
        }

        return List.of(carNames);
    }

    public int getTryCount() {
        System.out.println(magicVariable.ASK_TRY_COUNT_MESSAGE);
        try {
            int tryCount = Integer.parseInt(userInput);
            if (tryCount < 1) {
                throw new IllegalArgumentException(magicVariable.TRY_COUNT_RANGE_ERROR_MESSAGE);
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(magicVariable.TRY_COUNT_TYPE_ERROR_MESSAGE);
        }
    }
}
