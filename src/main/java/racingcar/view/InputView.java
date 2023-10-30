package racingcar.view;

import static racingcar.gameutil.GameMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.gameutil.GameMessage;
import racingcar.validator.InputValidator;

public class InputView {

    private InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    public String inputCarName() {
        System.out.println(CAR_NAME_INPUT_MSG.getMsg());
        String carName = Console.readLine();
        inputValidator.validateInputCarName(carName);
        return carName;
    }

    public Integer inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MSG.getMsg());
        String tryCount = Console.readLine();
        inputValidator.validateInputTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }
}
