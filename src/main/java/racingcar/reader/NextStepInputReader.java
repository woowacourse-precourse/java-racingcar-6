package racingcar.reader;

import camp.nextstep.edu.missionutils.Console;

public class NextStepInputReader implements InputReader {
    public String readLine() {
        return Console.readLine();
    }

    @Override
    public void close() {
        Console.close();
    }
}
