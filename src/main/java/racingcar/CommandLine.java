package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;

public class CommandLine {

    public static void showln(String message) {
        System.out.println(message);
    }

    public static void show(String message) {
        System.out.print(message);
    }

    public static String inputln(String message) {
        showln(message);
        return Console.readLine();
    }
}
