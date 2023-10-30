package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Constants;

public class SystemMessage {

    public String getCarList() {
        System.out.println(Constants.START_GAME);
        return Console.readLine();
    }

    public String getTrialNumber() {
        System.out.println(Constants.TRIAL);
        return Console.readLine();
    }
}
