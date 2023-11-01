package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validation;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

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