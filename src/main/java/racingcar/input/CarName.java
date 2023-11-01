package racingcar.input;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class CarName {

    private CarName() {
    }

    public static List<String> input() {
        String carName = Console.readLine();
        List<String> carNameList = Arrays.asList(carName.split(","));
        validateLength(carNameList);

        return carNameList;
    }
    private static void validateLength(List<String> carNameList) {
        for (String s : carNameList) {
            if (s.length() > 5 || s.length() < 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
