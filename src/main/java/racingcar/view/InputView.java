package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.StringUtil;
import racingcar.util.Validator;

public class InputView {
    public static String[] inputCarNames() {
        String carString = Console.readLine();
        String[] carNames = StringUtil.splitString(carString);
        for (String car : carNames) {
            Validator.nameLengthLimit(car);
        }
        return carNames;
    }

    public static int inputStageTimes() {
        String timesString = Console.readLine();
        Validator.isNumber(timesString);
        return Integer.parseInt(timesString);
    }
}
