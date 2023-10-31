package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Message;

public class InputView {
    public static String getTryCountFromUser() {
        System.out.println(Message.ASK_TRY_COUNT.getMessage());
        return Console.readLine();
    }

    public static String getNamesFromUser() {
        System.out.println(Message.INPUT_CAR_NAMES.getMessage());
        return Console.readLine();
    }
}