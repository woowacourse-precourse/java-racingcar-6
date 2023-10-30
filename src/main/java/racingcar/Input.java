package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static List<String> getCarInformation() {
        String userInput = Console.readLine();
        List<String> tmp = Arrays.asList(userInput.split(","));

        tmp.forEach(name -> {
            checkLengthOfName(name);
            checkHangleName(name);
            checkBlankName(name);
            checkNumberName(name);
        });

        return tmp;
    }

    private static void checkNumberName(String name) {
        if (name.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkHangleName(String name) {
        if (name.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static int getTriesInformation() {
        String userInput = Console.readLine();
        checkBlankTries(userInput);
        checkNumberFormatTries(userInput);

        int check = Integer.parseInt(userInput);
        checkNegativeTries(check);

        return check;
    }

    private static void checkNumberFormatTries(String userInput) {
        try {
            int check = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkBlankTries(String tries) {
        if (tries.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkNegativeTries(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }
    }
}
