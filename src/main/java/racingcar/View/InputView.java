package racingcar.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.Utils.InputValidator;

public class InputView {

    public static List<String> getCarNameList() {
        return InputValidator.checkCarNameList(readLine());
    }

    public static int getNumberOfAttempts() {
        return InputValidator.checkNumberOfAttempts(readLine());
    }
}
