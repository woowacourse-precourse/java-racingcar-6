package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.OutputFormatter;

public class InputReceiver {

    public String readCarNames() {
        System.out.println(OutputFormatter.getMessageWhenInputCarNames());
        return Console.readLine();
    }

    public String readNumOfTries() {
        System.out.println(OutputFormatter.getMessageWhenInputNumOfTries());
        return Console.readLine();
    }
}
