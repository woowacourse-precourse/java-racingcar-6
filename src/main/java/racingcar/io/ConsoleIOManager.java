package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleIOManager implements IOManager {

    @Override
    public String readString() {
        return Console.readLine();
    }
}
