package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class User {
    private static String input() {
        return Console.readLine();
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

    public static int stringToInteger() {
        return Integer.parseInt(input());
    }

    public static LinkedHashMap<String, Integer> carReset() {
        LinkedHashMap<String, Integer> racingCar = new LinkedHashMap<>();
        String[] input = splitInput(input());
        for (String car : input) {
            racingCar.put(car, 0);
        }
        return racingCar;
    }
}
