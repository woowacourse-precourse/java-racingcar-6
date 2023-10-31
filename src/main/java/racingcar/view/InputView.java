package racingcar.view;

import static racingcar.common.Constants.MESSAGE_OF_REQUEST_NAMES;
import static racingcar.common.Constants.MESSAGE_OF_REQUEST_TRY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestNames() {
        System.out.println(MESSAGE_OF_REQUEST_NAMES);
        return Console.readLine();
    }

    public void requestTryNumber() {
        System.out.println(MESSAGE_OF_REQUEST_TRY_NUMBER);
    }


}
