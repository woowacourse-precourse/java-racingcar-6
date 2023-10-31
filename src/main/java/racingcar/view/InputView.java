package racingcar.view;

import static racingcar.util.Message.INPUT_CAR_NAME;
import static racingcar.util.Message.INPUT_PLAY_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String carName() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    public static String playCount() {
        System.out.println(INPUT_PLAY_COUNT);
        String input = Console.readLine();
        System.out.println();

        return input;
    }
}
