package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputOutputInterface {
    public static List<String> listenCarName() {
        String inputString = Console.readLine();
        String[] splitedString = inputString.split(",");
        return Arrays.asList(splitedString);
    }
}
