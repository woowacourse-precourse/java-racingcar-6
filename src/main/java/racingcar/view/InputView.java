package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputJoinCarsName() {
        return Arrays.asList(Console.readLine().split(","));
    }

    public static String inputGameCount() {
        return Console.readLine();
    }
}
