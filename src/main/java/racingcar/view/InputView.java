package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import racingcar.validation.PlayTime;
import racingcar.validation.Registry;

public class InputView {
    public static List<String> askRegistry() {
        OutputView.printMessage(IOMessage.REGISTER_PLAYER);
        List<String> userInput = inputToList(readLine());
        Registry.isValid(userInput);
        return userInput;
    }

    public static Integer askPlayTime() {
        OutputView.printMessage(IOMessage.ATTEMPT_TIME);
        String userInput = readLine();
        PlayTime.isValid(userInput);
        return inputToInteger(userInput);
    }

    private static List<String> inputToList(String inputValue) {
        return Arrays.asList(inputValue.split(","));
    }

    private static int inputToInteger(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}
