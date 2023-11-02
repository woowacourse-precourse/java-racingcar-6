package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ViewMessage;
import racingcar.validator.CountInputValidator;

public class InputView {

    public String getCarNameInput() {
        System.out.println(ViewMessage.CAR_NAME_INPUT_MESSAGE.get());
        return Console.readLine();
    }

    public String getCountInput() {
        System.out.println(ViewMessage.COUNT_INPUT_MESSAGE);
        return Console.readLine();
    }
}
