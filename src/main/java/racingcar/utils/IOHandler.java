package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class IOHandler {
    private IOHandler() {
    }

    public static String readAndPrintInput() {
        String input = Console.readLine();
        System.out.println(input);
        return input;
    }

    public static void printOutput(String message) {
        System.out.println(message);
    }

    public static void close() {
        Console.close();
    }
}