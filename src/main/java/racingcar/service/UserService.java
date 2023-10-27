package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.MessageEnum;

public class UserService {
    public String inputItem() {
        return Console.readLine();
    }

    public int inputTryNumber(String tryNumber) {
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MessageEnum.INVALID_INPUT_MESSAGE.getMessage());
        }
    }
}
