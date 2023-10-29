package racingcar.input;

import Config.AppConfig;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static String readInput() {
        return Console.readLine();
    }

    public static String[] inputStringToArray() {
        String input = readInput();
        String[] array = input.split(AppConfig.INPUT_NAME_DELIMITER, AppConfig.PARTICIPANT_MAX);

        if (array.length < AppConfig.PARTICIPANT_MIN) {
            throw new IllegalArgumentException("참가자는 " + AppConfig.PARTICIPANT_MIN + "명 이상입니다.");
        }

        return array;
    }
}
