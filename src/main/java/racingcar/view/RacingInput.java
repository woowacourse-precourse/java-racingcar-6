package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.InputValidator;

public class RacingInput {

    public static List<String> readCarName() {
        return InputValidator.checkInputCarNameList(readLine());
    }

    public static int readTryNumber() {
        return InputValidator.checkInputTryNumber(readLine());
    }
}
