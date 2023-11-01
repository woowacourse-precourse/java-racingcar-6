package racingcar.view;

import static racingcar.utils.Constants.INPUT_CARS_NAME;
import static racingcar.utils.Constants.INPUT_GAME_TRY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarsName() {
        System.out.println(INPUT_CARS_NAME);
        return Console.readLine();
    }

    public static String inputGameTryNumber() {
        System.out.println(INPUT_GAME_TRY_NUMBER);
        return Console.readLine();
    }
}
