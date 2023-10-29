package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputView {
    MagicVariable magicVariable = new MagicVariable();

    public InputView() {}

    public String getCarNameInput() {
        System.out.println(magicVariable.RACE_START_MESSAGE);
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        checkCarNameExceptions(carNames);
        return String.join(",", carNames);
    }

    private void checkCarNameExceptions(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException(magicVariable.CAR_DUPLICATE_ERROR_MESSAGE);
        }

        for (String carName : carNames) {
            if (!carName.matches(magicVariable.CAR_NAME_RULE)) {
                throw new IllegalArgumentException(magicVariable.CAR_NAME_ERROR_MESSAGE);
            }
        }
    }

    public int getTryCount() {
        System.out.println(magicVariable.ASK_TRY_COUNT_MESSAGE);
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= magicVariable.PICK_NUM_MIN) {
            throw new IllegalArgumentException(magicVariable.TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
        return tryCount;
    }
}

