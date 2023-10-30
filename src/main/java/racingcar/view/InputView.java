package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.consts.ConstString.INPUT_TRY_NUMBER;
import static racingcar.consts.ConstString.START_INPUT_MESSAGE;

public class InputView {
    public String carNameInput(){
        System.out.println(START_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String setNumberInput(){
        System.out.println(INPUT_TRY_NUMBER);
        return Console.readLine();
    }
}
