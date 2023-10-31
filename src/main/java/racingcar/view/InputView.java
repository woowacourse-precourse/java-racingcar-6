package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ViewMessage;
import racingcar.validator.CountInputValidator;

public class InputView {
    private final CountInputValidator countInputValidator = new CountInputValidator();

    public String getCarNameInput() {
        System.out.println(ViewMessage.CAR_NAME_INPUT_MESSAGE.get());
        return Console.readLine();
    }

    public int getCountInput() {
        System.out.println(ViewMessage.COUNT_INPUT_MESSAGE);
        String playerInput = Console.readLine();
        countInputValidator.validate(playerInput);
        return Integer.parseInt(playerInput);
    }
}
