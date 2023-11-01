package view;

import static constants.InputMessages.REQUEST_CAR_NAMES;
import static constants.InputMessages.REQUEST_TRY_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] getCarNames() {
        System.out.println(REQUEST_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return inputCarNames.split(",");
    }

    public static String getTryCount() {
        System.out.println(REQUEST_TRY_COUNT);
        String tryCount = Console.readLine();
        System.out.println();
        return tryCount;
    }
}
