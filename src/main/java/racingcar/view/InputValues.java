package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.SystemMessage;

public class InputValues {

    public String getName() {
        System.out.println(SystemMessage.SET_CAR_NAME_MESSAGE.getMessage());
        String getName =  Console.readLine();
        Console.close();
        return getName;
    }

    public String getCount() {
        System.out.println(SystemMessage.SET_TRY_COUNT_MESSAGE.getMessage());
        String getCount = Console.readLine();
        Console.close();
        System.out.println(getCount);
        return getCount;
    }
}
