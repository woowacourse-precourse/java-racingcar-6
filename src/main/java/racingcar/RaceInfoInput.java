package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RaceInfoInput {
    public static String[] inputCarName(){
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return carNames;
    }

    public static String inputNumberOfAttempts(){
        String input = Console.readLine();
        return input;
    }
}
