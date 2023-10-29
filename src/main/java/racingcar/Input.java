package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    public static List<String> getCarInformation() {
        String userInput = Console.readLine();
        List<String> tmp = Arrays.asList(userInput.split(","));
        tmp.forEach(Input::checkLengthOfName);

        return tmp;
    }

    private static void checkLengthOfName(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException();
        }
    }

    public static int getTriesInformation() {
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
