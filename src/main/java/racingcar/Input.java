package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    static boolean isEmpty(String[] carNames) {
        if (carNames.length == 0) {
            return (true);
        }
        return (false);
    }

    static boolean isOutOfRange(long tryNumber) {
        return (tryNumber > 2000000000 || tryNumber < 0);
    }

    static String[] getCarName() {
        String carNameInput = Console.readLine();
        String[] carNames = carNameInput.split(",");
        if (isEmpty(carNames))
            Exception.generateInvalidCarNumberException();
        return (carNames);
    }

    static int getTryNumber() {
        String tryNumberInput = Console.readLine();
        if (tryNumberInput.length() > 10) {
            Exception.generateInvalidTryNumberRangeException();
        }
        long tryNumber = 0;
        try {
            tryNumber = Long.parseLong(tryNumberInput);
            if (isOutOfRange(tryNumber)) {
                Exception.generateInvalidTryNumberRangeException();
            }
        } catch (NumberFormatException numberFormatException) {
            Exception.generateInvalidNumberCharacterException();
        }
        return ((int) tryNumber);
    }
}
