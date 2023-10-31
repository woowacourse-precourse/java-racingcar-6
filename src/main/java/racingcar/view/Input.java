package racingcar.view;

import static racingcar.constant.InputStringConstant.GET_NAMES;
import static racingcar.constant.InputStringConstant.GET_ROUND_NUM;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String getNames() {
        System.out.println(GET_NAMES.getValue());
        return Console.readLine();
    }

    public String getRound() {
        System.out.println(GET_ROUND_NUM.getValue());
        return Console.readLine();
    }
}
