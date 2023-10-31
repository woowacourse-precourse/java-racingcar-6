package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    static ExceptionChecker exceptionChecker = new ExceptionChecker();
    static List<String> carNameList = new ArrayList<String>();

    public static String inputString(String inputText) {
        System.out.println(inputText);
        String inputStr = Console.readLine();
        return inputStr;
    }

    public static void stringToList(String strCarName) {
        // List<String> carNameList = new ArrayList<String>();
        if (strCarName.contains(",")) {
            carNameList = Arrays.asList(strCarName.split(","));
        } else if (!strCarName.contains(",")) {
            carNameList = Arrays.asList(strCarName);
        }
        // return carNameList;
    }

    public static List<String> getCarName(String inputText) {
        // 자동차 이름 입력받기
        String strCarName = inputString(inputText);
        exceptionChecker.wrongInputCarName(strCarName);
        stringToList(strCarName);
        return carNameList;
    }

    public static int getNumberOfTries(String inputText) {
        String strTries = inputString(inputText);
        exceptionChecker.wrongInputTries(strTries);
        return Integer.parseInt(strTries);
    }
}