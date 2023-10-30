package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Computer {
    public static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
