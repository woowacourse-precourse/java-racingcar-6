package racingcar.view;

import static racingcar.constant.MessageConst.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputRacingCount() {
        System.out.println(INPUT_CAR_MOVING_PLAYTIME);
        return Console.readLine();
    }
}
