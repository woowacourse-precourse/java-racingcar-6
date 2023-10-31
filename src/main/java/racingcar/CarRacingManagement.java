package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class CarRacingManagement {
    public static void startRacing () {
        String inputValue = Console.readLine();
        inputValue = inputValue.replaceAll(" ", "");
        StringTokenizer stringCarList = new StringTokenizer(inputValue, ",");
    }
}
