package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Validation;

public class InputView {
    public static String[] inputCarName() {
        String inputCarNames = Console.readLine();
        String[] carArray = inputCarNames.split(",");
        return carArray;
    }

    public static String inputTryNumber() {
        return Console.readLine();
    }
}
