package racingcar;

import java.math.BigInteger;

public class Preprocessor {

    protected static String[] processCarNames(String[] carNames) {
        trimCarName(carNames);
        replaceNoName(carNames);
        checkCarNames(carNames);
        return carNames;
    }

    private static void checkCarNames(String[] carNames) {
        checkEmpty(carNames);
        checkCarNamesLength(carNames);
    }

    private static void checkEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    protected static void checkCarNamesLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static void trimCarName(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private static void replaceNoName(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].isEmpty()) {
                carNames[i] = "null";
            }
        }
    }

    protected static int processNumOfMoves(String userInput) {
        return parseNumOfMoves(userInput);
    }

    protected static int parseNumOfMoves(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            String errorMessage = processNumberFormatException(userInput);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static String processNumberFormatException(String userInput) {
        try {
            new BigInteger(userInput);
        } catch (NumberFormatException ne) {
            return "숫자를 입력해주세요.";
        }
        return Integer.MAX_VALUE + "보다 작은 수를 입력해주세요.";
    }
}
