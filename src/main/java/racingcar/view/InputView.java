package racingcar.view;

import racingcar.constants.UtilConstant;
import racingcar.constants.InputMessage;
import racingcar.model.Round;
import racingcar.util.Util;

public class InputView {

    public static String[] inputCarNames() {
        System.out.println(InputMessage.INPUT_CAR_NAMES.getMessage());
        return Util.readLine().split(UtilConstant.SEPARATOR.getStringValue());
    }

    public static Round inputRoundNumber() {
        System.out.println(InputMessage.INPUT_ROUND_NUMBER.getMessage());
        String input = Util.readLine();
        return Round.from(input);
    }
}
