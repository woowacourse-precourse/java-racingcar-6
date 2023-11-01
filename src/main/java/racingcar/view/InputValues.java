package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.SystemMessage;

public class InputValues {

    public String getName() {
        System.out.println(SystemMessage.SET_CAR_NAME_MESSAGE.getMessage());
        String getName =  Console.readLine();
        Console.close();
        System.out.println(getName); //테스트 로그, 제출 시 삭제예정
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
