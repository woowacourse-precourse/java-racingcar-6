package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.variable.MagicVariable;

public class InputView {
    public InputView() {}

    private void carNameDuplicateException(String[] carNames, Set<String> uniqueNames) {
        if (uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException(MagicVariable.CAR_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void carNameRullException(String carName) {
        if (!carName.matches(MagicVariable.CAR_NAME_RULE)) {
            throw new IllegalArgumentException(MagicVariable.CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void checkCarNameExceptions(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        carNameDuplicateException(carNames, uniqueNames);

        for (String carName : carNames) {
            carNameRullException(carName);
        }
    }

    public void testCarNameExceptions(String[] carNames) {
        checkCarNameExceptions(carNames);
    }

    public String getCarNameInput() {
        System.out.println(MagicVariable.RACE_START_MESSAGE);
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        checkCarNameExceptions(carNames);
        return String.join(",", carNames);
    }

    public int getTryCount() {
        System.out.println(MagicVariable.ASK_TRY_COUNT_MESSAGE);
        int tryCount = Integer.parseInt(Console.readLine());
        checkTryCountExceptions(tryCount);
        return tryCount;
    }

    public void checkTryCountExceptions(int tryCount) {
        if (tryCount <= MagicVariable.PICK_NUM_MIN) {
            throw new IllegalArgumentException(MagicVariable.TRY_COUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public void testTryCountExceptions(int tryCount) {
        checkTryCountExceptions(tryCount);
    }
}

