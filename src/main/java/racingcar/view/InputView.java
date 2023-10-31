package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;

import java.util.*;

public class InputView {

    public static List<String> carName() {
        String input = Console.readLine();

        List<String> carNameList = Arrays.asList(input.split(","));

        inputCarValidation(input, carNameList);

        return carNameList;
    }

    public static void inputCarValidation(String input, List<String> carNameList) {
        Validation.stringImpossibleRest(input);
        Validation.stringCurrentCheck(carNameList);
        Validation.stringLengthExceed(carNameList);
        Validation.stringNoName(carNameList);
        Validation.impossibleRacing(carNameList);
    }

    public static int attempt() {
        String input = Console.readLine();

        inputAttemptValidation(input);

        int attempt = Integer.parseInt(input);

        return attempt;
    }

    public static void inputAttemptValidation(String input) {
        Validation.noZeroNumber(input);
        Validation.onlyPossibleNumber(input);
    }

}
