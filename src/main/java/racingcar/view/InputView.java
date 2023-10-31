package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.RaceMessage.INPUT_CAR_NAMES;
import static racingcar.constant.RaceMessage.INPUT_NUMBER_OF_ATTEMPTS;

public class InputView {
    public static List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        String input = Console.readLine();
        return Arrays.asList(input.split(","));
    }

    public static String inputNumberOfAttempts() {
        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        return Console.readLine();
    }
}