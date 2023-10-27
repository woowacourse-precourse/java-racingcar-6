package util;

import camp.nextstep.edu.missionutils.Console;

public interface InputReader {
    private String readStringInput() throws IllegalArgumentException {
        return Console.readLine();
    }

    private int readIntInput() throws IllegalArgumentException{
        return Integer.parseInt(Console.readLine());
    };
}
