package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.MessageUtil;

public class Input {

    public String  inputCarName () {
        System.out.println(MessageUtil.Carname_Message);

        return Console.readLine();
    }

    public String inputTryNumber () {
        System.out.println(MessageUtil.Try_Message);

        return Console.readLine();
    }

}
