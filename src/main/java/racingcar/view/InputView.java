package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.MessageConstant;

public class InputView {

    public String inputCarNames() {
        System.out.println(MessageConstant.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public int inputTryNumber() {
        System.out.println(MessageConstant.INPUT_TRY_NUMBER);
        String string = Console.readLine();
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
