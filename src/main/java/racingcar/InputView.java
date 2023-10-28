package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    MagicVariable magicVariable = new MagicVariable();

    public InputView() {}

    public String getCarNameInput() {
        System.out.println(magicVariable.RACE_START_MESSAGE);
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");

        for (String carName : carNames) {
            if (!carName.matches(magicVariable.CAR_NAME_RULE)) {
                throw new IllegalArgumentException(magicVariable.CAR_NAME_ERROR_MESSAGE);
            }
        }

        return String.join(",", carNames);
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

