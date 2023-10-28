package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

class Typing {

    private Typing() {
    }
    public static List<String> inputCarName() {
        String carName = Console.readLine();
        List<String> carNameList = Arrays.asList(carName.split(","));
        if (hasCarNameOverFiveOrUnderOne(carNameList)) {
            throw new IllegalArgumentException();
        }

        return carNameList;
    }
    private static boolean hasCarNameOverFiveOrUnderOne(List<String> carNameList) {
        for (String s : carNameList) {
            if (s.length() > 5 || s.length() < 1) {
                return true;
            }
        }
        return false;
    }

}