package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

import static racingcar.validator.Constants.*;

public class InputView {
    public String inputPlayer(){
        System.out.println(START_NAME_MESSAGE);
        return Console.readLine();
    }
    public String inputNum(){
        System.out.println(START_NUM_MESSAGE);
        return Console.readLine();
    }
}
