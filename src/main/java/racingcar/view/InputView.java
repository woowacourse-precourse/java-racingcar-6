package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constant;

public class InputView {
    public static String requestCarName(){
        System.out.println(Constant.REQUEST_CAR_NAME);
        return Console.readLine();
    }

    public static String requestNumberOfTry(){
        System.out.println(Constant.REQUEST_NUMBER_OF_TRY);
        return Console.readLine();
    }
}
