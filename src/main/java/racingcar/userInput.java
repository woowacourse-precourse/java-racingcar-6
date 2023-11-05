package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constants;

public class userInput {

    public static String inputNames() {
        System.out.println(Constants.carsStr);
        return Console.readLine();
    }

    public static String inputNumber() {
        System.out.println(Constants.countStr);
        return Console.readLine();
    }
}
