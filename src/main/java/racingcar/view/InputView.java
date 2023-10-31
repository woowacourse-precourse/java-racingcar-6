package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.MessageConstant;

import java.util.List;

public class InputView {

    public String inputCarNames() {
        System.out.println(MessageConstant.INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public int inputTryNumber() {
        System.out.println(MessageConstant.INPUT_TRY_NUMBER_MESSAGE);
        String string = Console.readLine();
        return Integer.parseInt(string);
    }
}
