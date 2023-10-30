package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public static String readInput() {
        return Console.readLine();
    }

    public static String[] getInputTypeToStringArray(){
        String input = readInput();
        return input.split(AppConfig.INPUT_DELIMITER, Integer.MAX_VALUE);
    }
}
