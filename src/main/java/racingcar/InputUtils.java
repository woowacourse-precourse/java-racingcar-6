package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class InputUtils {

    static boolean isOutOfRange(long tryNumber) {
        return (tryNumber > 100 || tryNumber < 1);
    }

    static  boolean containsDuplicates(String[] carNames) {
        Set<String> duplicateChecker = new HashSet<>();
        for (String carName : carNames) {
            if (!duplicateChecker.add(carName)) {
                return true;
            }
        }
        return false;
    }

    static void checkEmptyOrBlankCarNames(String carNameInput) {
        if (carNameInput.isBlank() || carNameInput.isEmpty()) {
            Exception.generateInvalidCarNumberException();
        }
    }

    static void checkDuplicateCarNames(String[] carNames) {
        if (containsDuplicates(carNames)) {
            Exception.generateInvalidDuplicateCarNameException();
        }
    }

    static void checkTryNumberRange(long tryNumber) {
        if (isOutOfRange(tryNumber)) {
            Exception.generateInvalidTryNumberRangeException();
        }
    }

    static void checkTryNumberInputLength(String tryNumberInput) {
        if (tryNumberInput.length() > 10) {
            Exception.generateInvalidTryNumberRangeException();
        }
    }

    static String readCarNameInput() {
        String carNameInput = null;
        try {
            carNameInput = Console.readLine();
        } catch (NoSuchElementException noSuchElementException) {
            Exception.generateInvalidCarNumberException();
        }
        return carNameInput;
    }

    static String[] splitCarNameInput(String carNameInput) {
        String[] carNames = null;
        try {
            carNames = carNameInput.split(",");
        } catch (Error OutOfMemoryError) {
            Exception.generateOutOfMemoryError();
        }
        return (carNames);
    }

}
