package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.RacingMessage;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryNumValidator;

public class InputView {
    private static InputView instance;

    private InputView() {

    }

    public static InputView getInstance() {
        if(instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readCarNames() {
        System.out.println(RacingMessage.INPUT_NAME_MESSAGE.getMessage());
        String inputCarNames = Console.readLine().trim();
        new CarNameValidator().validate(inputCarNames);
        return inputCarNames;
    }

    public Integer readTryNum() {
        System.out.println(RacingMessage.INPUT_MOVE_NUM_MESSAGE.getMessage());
        String tryNum = Console.readLine().trim();
        new TryNumValidator().validate(tryNum);
        return Integer.parseInt(tryNum);
    }
}
