package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;

public class InputView {

    public static String inputCarName() {
        return Console.readLine();
    }

    public static Integer inputRacingCount() {
        String input = Console.readLine();
        Validation.checkCountType(input);
        return Integer.parseInt(input);
    }
}