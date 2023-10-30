package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Computer {
    public static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }



    public static int createRoundCount(String userInput) {
        Validator.checkPositiveNumber(userInput);
        return Integer.parseInt(userInput);
    }
}
