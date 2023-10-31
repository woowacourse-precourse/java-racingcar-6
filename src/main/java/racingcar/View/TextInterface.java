package racingcar.View;

import static racingcar.Util.Constants.ENTER_REPETITION;
import static racingcar.Util.Constants.ENTER_USER;

import camp.nextstep.edu.missionutils.Console;

public class TextInterface {
    public String enterPlayer(){
        System.out.println(ENTER_USER);
        return Console.readLine();
    }

    public String enterRepetition(){
        System.out.println(ENTER_REPETITION);
        return Console.readLine();
    }
}
