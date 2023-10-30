package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Messages;

public class RacingCarInputView {
    public String carNameInput() {
        System.out.println(Messages.GUIDE_INPUT_NAME_MESSAGE);
        String names = Console.readLine();
        return names;
    }

    public String carNumberInput() {
        System.out.println(Messages.GUIDE_INPUT_NUMBER_MESSAGE);
        String number = Console.readLine();
        return number;
    }
}
