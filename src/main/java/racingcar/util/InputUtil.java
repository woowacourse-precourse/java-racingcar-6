package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
    public static int readInt() {
        String input = Console.readLine();
        InputValidator.validateInteger(input);
        return Integer.parseInt(input);
    }

    public static String[] readLine(){
        String input = Console.readLine();
        String[] car = input.split(",");

        InputValidator.validateInputCondition(input, car);

        for(String name: car){
            InputValidator.validateCarName(name);
        }
        return car;
    }
}
