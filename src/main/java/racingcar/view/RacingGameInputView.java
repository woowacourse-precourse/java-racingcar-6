package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RacingGameInputView {

    public static String next() {
        return Console.readLine();
    }

    public static Integer nextInt() {
        return Integer.parseInt(next());
    }

    public static String[] nextStringArray() {
        return next().split(",");
    }
}
