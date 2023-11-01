package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constants;

public class InputView {
    public static String requestRacingCarNames() {
        System.out.println(Constants.REQUEST_CAR_MESSAGE);
        return Console.readLine();
    }

    public static String requestRepetitionNumber() {
        System.out.println(Constants.REQUEST_REPETITION);
        return Console.readLine();
    }
}