package view;

import camp.nextstep.edu.missionutils.Console;
import message.InputMessages;

public class InputView {

    public String[] getCarNames() {
        System.out.println(InputMessages.REQUEST_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return inputCarNames.split(",");
    }

    public String getTryCount() {
        System.out.println(InputMessages.REQUEST_TRY_COUNT);
        String tryCount = Console.readLine();
        System.out.println();
        return tryCount;
    }
}
