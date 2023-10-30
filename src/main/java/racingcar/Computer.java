package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Computer {
    public static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public static List<String> createCarNames(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    public static void trimCarNames(List<String> carNames) {
        carNames.replaceAll(String::trim);
    }

    public static int createRoundCount(String userInput) {
        Validator.checkPositiveNumber(userInput);
        return Integer.parseInt(userInput);
    }



}
