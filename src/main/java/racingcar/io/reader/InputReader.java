package racingcar.io.reader;

import camp.nextstep.edu.missionutils.Console;

public class InputReader implements StdReader {
    @Override
    public String readLine() {
        return Console.readLine().trim();
    }
}
