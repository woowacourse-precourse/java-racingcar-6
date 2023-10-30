package racingcar.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.Registry;

public class Input {

    public static List<String> setRegistry() {
        List<String> userInput = inputToList(readLine());
        Registry.isValid(userInput);
        return userInput;
    }

    private static List<String> inputToList(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

}
