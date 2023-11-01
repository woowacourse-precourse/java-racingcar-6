package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String inputCarName() {
        return Console.readLine();
    }
    public static Integer inputRacingCount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}