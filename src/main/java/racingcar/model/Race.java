package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.Cars;

public class Race {
    final static int MORE = 4;



    private static boolean forwardCondition() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MORE)
            return true;
        return false;
    }
}
