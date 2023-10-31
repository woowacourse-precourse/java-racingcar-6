package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static constant.MessgeList.INPUT_ATTEMPT_NUMBER_MESSAGE;
import static constant.MessgeList.INPUT_CAR_NAME_MESSAGE;

public class InputView {
    public static String getCarNameFromPlayer() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static String getNumberFromPlayer() {
        System.out.println(INPUT_ATTEMPT_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
