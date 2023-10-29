package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static boolean isEmpty(String[] carNames) {
        if (carNames.length == 0) {
            return (true);
        }
        return (false);
    }
    static String[] getCarName() {
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        if (isEmpty(carNames))
            Exception.generateInvalidCarNumberException();
        return (carNames);
    }

    static int getTryNumber() throws IllegalArgumentException {
        String tryNumberInput = Console.readLine();
        int tryNumber = 0;
        try {
            tryNumber = Integer.parseInt(tryNumberInput);
        } catch (NumberFormatException numberFormatException) {
            Exception.generateInvalidNumberCharacterException();
        }
        return (tryNumber);
    }
}
