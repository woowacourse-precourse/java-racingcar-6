package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.GameConstant;
import racingcar.constants.InputMessage;
import racingcar.model.Round;

public class InputView {

    public static String[] inputCarNames() {
        System.out.println(InputMessage.INPUT_CAR_NAMES.getMessage());
        return Console.readLine().split(GameConstant.SEPARATOR.getStringValue());
    }

    public static Round inputRoundNumber() {
        System.out.println(InputMessage.INPUT_ROUND_NUMBER.getMessage());
        String input = Console.readLine();
        return Round.from(input);
    }
}
