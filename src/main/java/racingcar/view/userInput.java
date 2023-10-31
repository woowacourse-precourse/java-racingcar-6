package racingcar.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class userInput {

    public static List<String> getCarNames(){
        String carNames = readLine();
        return Arrays.asList(carNames.split(","));
    }
    public static int getTryNumber(){
        return Integer.parseInt(readLine());
    }
    private static String readLine(){
        return Console.readLine();
    }

}
