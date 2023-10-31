package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputSource implements InputSource {

    @Override
    public String readInput() {
        return Console.readLine();
    }

}
