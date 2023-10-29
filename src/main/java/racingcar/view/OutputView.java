package racingcar.view;

import static racingcar.constant.RaceMessage.*;

public class OutputView {
    public void carNamesOutput() {
        System.out.println(INIT_CAR_NAMES_MESSAGE.getMessage());
    }

    public void countOutput() {
        System.out.println(INIT_COUNT_MESSAGE);
    }
}
