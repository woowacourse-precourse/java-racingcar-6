package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputOutputHelper implements InputOutputHelper {
    @Override
    public String input() {
        return Console.readLine();
    }

    @Override
    public String output(String message) {
        System.out.print(message);
        return message;
    }
}