package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.utils.InputValidator;

public class InputView {

    public static List<String> getCarNameList() {
        return InputValidator.checkCarNameList(readLine());
    }

    public static int getNumberOfAttempts() {
        return InputValidator.checkNumberOfAttempts(readLine());
    }
}
