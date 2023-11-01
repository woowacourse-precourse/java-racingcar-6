package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constants;

public class RaceStartView {

    public String getCarName() {
        System.out.println(Constants.INPUT_CAR_NAME_PROMPT);
        return Console.readLine();
    }

    public String getRaceLap() {
        System.out.println(Constants.INPUT_RACE_LAP_PROMPT);
        return Console.readLine();
    }
}
