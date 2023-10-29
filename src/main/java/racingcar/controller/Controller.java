package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    static String input;

    public static List<String> readCarName() {
        input = Console.readLine();

        String[] carName = input.split(",");
        return new ArrayList<>(Arrays.asList(carName));
    }

    public static int readCount() {
        input = Console.readLine();
        return Integer.parseInt(input);
    }
}
