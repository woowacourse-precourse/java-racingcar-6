package racingcar.input;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String readInput() {
        return Console.readLine();
    }

    public static String[] inputStringToArray() {
        String input = readInput();
        String[] array = input.split(AppConfig.INPUT_NAME_DELIMITER, AppConfig.INPUT_NAME_QUANTITY_LIMIT);
        return array;
    }
}
