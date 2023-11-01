package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    public String getCarNames() {
        return readLine();
    }

    public int getTries() {
        return Integer.parseInt(readLine());
    }
}
