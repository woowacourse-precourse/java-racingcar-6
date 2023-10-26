package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.system.SystemMessage;

public class InputHandler {
    public static String inputCars() {
        System.out.println(SystemMessage.INPUT_CAR_NAME.getMessage());
        return Console.readLine();
    }
}
