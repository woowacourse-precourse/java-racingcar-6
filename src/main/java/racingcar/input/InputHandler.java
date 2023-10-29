package racingcar.input;

import config.CarConfig;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String readInput() {
        return Console.readLine();
    }

    public static String[] inputStringToArray() {
        String input = readInput();
        String[] array = input.split(CarConfig.INPUT_NAME_DELIMITER, CarConfig.INPUT_NAME_QUANTITY_LIMIT);
        return array;
    }
}
