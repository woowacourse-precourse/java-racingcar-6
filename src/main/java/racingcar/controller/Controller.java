package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    static String input;

    public static List<String> splitName(String input) {
        String[] carName = input.split(",");
        return new ArrayList<>(Arrays.asList(carName));
    }

    public static int readCount() {
        input = Console.readLine();
        Validator.isNumber(input);
        return Integer.parseInt(input);
    }

    public static int makeRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
