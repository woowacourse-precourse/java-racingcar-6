package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.StringJoiner;
import racingcar.model.CarModel;

public class Util {

    private static final int CAN_FORWARD = 4;

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isUpperThanCanForwardNumber(int targetNumber) {
        return targetNumber >= CAN_FORWARD;
    }

    public String generateWinnerList(List<CarModel> winners) {
        StringJoiner result = new StringJoiner(", ");

        for (CarModel winner : winners) {
            result.add(winner.getName());
        }
        return result.toString();
    }
}
