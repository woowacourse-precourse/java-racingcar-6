package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.IOManager;

public class ConsoleIOManager implements IOManager {

    @Override
    public String readString() {
        return Console.readLine();
    }
}
