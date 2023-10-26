package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.system.SystemMessage;

public class InputHandler {
    public static String inputCars() {
        System.out.println(SystemMessage.INPUT_CAR_NAME.getMessage());
        return Console.readLine();
    }

    public static String inputNumberOfTry() {
        System.out.println(SystemMessage.INPUT_NUMBER_OF_TRY.getMessage());
        return Console.readLine();
    }
}
