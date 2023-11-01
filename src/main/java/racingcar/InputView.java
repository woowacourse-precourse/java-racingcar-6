package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    static ExceptionChecker exceptionChecker = new ExceptionChecker();

    public static String inputString(String inputText) {
        System.out.println(inputText);
        return Console.readLine();
    }

    public static List<String> stringToList(String strCarName) {
        List<String> carNameList = new ArrayList<>();
        if (strCarName.contains(",")) {
            carNameList = Arrays.asList(strCarName.split(","));
        } else if (!strCarName.contains(",")) {
            carNameList = List.of(strCarName);
        }
        return carNameList;
    }

    public static List<String> getCarName(String inputText) {
        String strCarName = inputString(inputText);
        exceptionChecker.wrongInputCarName(strCarName);
        return stringToList(strCarName);
    }

    public static int getNumberOfTries(String inputText) {
        String strTries = inputString(inputText);
        exceptionChecker.wrongInputTries(strTries);
        return Integer.parseInt(strTries);
    }
}