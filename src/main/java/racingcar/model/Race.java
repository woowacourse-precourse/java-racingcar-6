package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.Cars;
import racingcar.view.ScorePrint;

public class Race {
    final static int MORE = 4;

    public static int[] racing(int currentCarLocation[], int MaxCarNumber) {
        for (int CarNumber = 0; CarNumber < MaxCarNumber; CarNumber++) {
            if (forwardCondition())
                currentCarLocation[CarNumber]++;
        }
        return currentCarLocation;
    }

    private static boolean forwardCondition() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= MORE)
            return true;
        return false;
    }
}
