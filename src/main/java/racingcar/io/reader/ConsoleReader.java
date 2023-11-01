package racingcar.io.reader;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {

    @Override
    public String readLine() {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
