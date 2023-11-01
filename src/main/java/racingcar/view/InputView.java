package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String setCarNames() {
        System.out.println(SystemMessage.SET_CAR_NAME_MESSAGE);
        System.out.println();
        return Console.readLine();
    }

    public static String setTryNumber() {
        System.out.println(SystemMessage.SET_GAME_TRY_MESSAGE);
        System.out.println();
        return Console.readLine();
    }
}
