package racingcar.io;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static racingcar.constant.Constant.CAR_NAME_SEPARATOR;


public class InputView {

    public static List<String> readCarNames() {
        return Arrays.stream(readLine().split(CAR_NAME_SEPARATOR))
                .toList();
    }
    private static String readLine() {
        return Console.readLine();
    }
}
