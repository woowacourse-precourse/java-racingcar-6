package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {

    static boolean isOutOfRange(long tryNumber) {
        return (tryNumber > 2000000000 || tryNumber < 0);
    }

    static String[] getCarName() {
        String carNameInput = "";
        try {
            carNameInput = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            Exception.generateInvalidCarNumberException();
        }
        carNameInput = carNameInput.replaceAll("^,+|,+$", "").replaceAll(",+", ",");
        if (carNameInput.isBlank() || carNameInput.isEmpty()) {
            Exception.generateInvalidCarNumberException();
        }
        String[] carNames = carNameInput.split(",");
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
