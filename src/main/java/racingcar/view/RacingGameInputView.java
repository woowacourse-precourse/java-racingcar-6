package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class RacingGameInputView {

    public static String next() {
        return Console.readLine();
    }

    public static Integer nextInt() {
        return Integer.parseInt(next());
    }

    public static String[] nextStringArray() {
        return Arrays.stream(next().split(","))
                .filter((item) -> !item.isEmpty())
                .toArray(String[]::new);
    }
}
