package util.inputreader;

import camp.nextstep.edu.missionutils.Console;

public interface InputReader {
    default String readStringInput() throws IllegalArgumentException {
        return Console.readLine();
    }

    default int readIntInput() throws IllegalArgumentException{
        return Integer.parseInt(Console.readLine());
    };
}
